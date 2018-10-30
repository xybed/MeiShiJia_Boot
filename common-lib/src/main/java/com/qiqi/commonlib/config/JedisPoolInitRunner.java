package com.qiqi.commonlib.config;

import com.qiqi.commonlib.utils.JedisUtil;
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
        logger.info("redis初始化成功.................................");
        JedisUtil.getInstance().initJedisPool(ip, Integer.parseInt(port));
    }
}
