package com.qiqi.commonredis.config;

import com.qiqi.commonredis.utils.JedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
@Order(value = 1)
public class JedisPoolInitRunner implements ApplicationRunner {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.redis.host}")
    private String ip;
    @Value("${spring.redis.port}")
    private String port;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            /**
             * 如果你遇到 java.net.SocketTimeoutException: Read timed out exception的异常信息
             *  请尝试在构造JedisPool的时候设置自己的超时值.
             * JedisPool默认的超时时间是2秒(单位毫秒) JedisPoolConfig
             */
            JedisPoolConfig poolConfig = new JedisPoolConfig();
            poolConfig.setMaxTotal(1024);
            poolConfig.setMaxIdle(200);
            poolConfig.setMaxWaitMillis(1000);
            poolConfig.setTestOnBorrow(true);

            JedisPool pool = new JedisPool(poolConfig, ip, Integer.parseInt(port), 2000);
            JedisUtil.setJedisPool(pool);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
