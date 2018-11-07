package com.qiqi.commonredis.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private JedisPool jedisPool = null;

    private JedisUtil(){}

    public static JedisUtil getInstance() {
        return RedisUtilHolder.instance;
    }

    public void initJedisPool(String ip, int port) {
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

            jedisPool = new JedisPool(poolConfig, ip, port, 2000);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例 没有绑定关系，而且只有被调用到时才会装载，从而实现了延迟加载。
     */
    private static class RedisUtilHolder {

        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static JedisUtil instance = new JedisUtil();
    }

    private Jedis getJedis(){
        return jedisPool.getResource();
    }

    /**
     * 释放redis实例到连接池.
     *
     * @param jedis
     *            redis实例
     */
    private void closeJedis(Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResourceObject(jedis);
        }
    }

    public void set(String key, String value){
        Jedis jedis = getJedis();
        jedis.set(key, value);
        closeJedis(jedis);
    }

    public String get(String key){
        Jedis jedis = getJedis();
        String value = jedis.get(key);
        closeJedis(jedis);
        return value;
    }

    public void del(String key){
        Jedis jedis = getJedis();
        jedis.del(key);
        closeJedis(jedis);
    }

    public void expire(String key, int seconds){
        Jedis jedis = getJedis();
        jedis.expire(key, seconds);
        closeJedis(jedis);
    }

}
