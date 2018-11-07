package com.qiqi.commonredis.config;

import com.qiqi.commonredis.utils.JedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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
