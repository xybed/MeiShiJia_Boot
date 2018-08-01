package com.qiqi.msjapi.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                //格式化缓存key字符串
                StringBuilder sb = new StringBuilder();
                //追加类名
                sb.append(o.getClass().getName());
                //追加方法名
                sb.append(method.getName());
                //遍历参数并且追加
                for (Object obj : objects){
                    sb.append(obj.toString());
                }
                logger.info("调用Redis缓存Key："+sb.toString());
                return sb.toString();
            }
        };
    }

//    @Bean
//    public CacheManager cacheManager(RedisTemplate redisTemplate){
//        return new RedisCacheManager(redisTemplate);
//    }
}
