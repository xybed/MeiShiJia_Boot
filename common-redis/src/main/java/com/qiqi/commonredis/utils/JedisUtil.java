package com.qiqi.commonredis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtil {

    private static JedisPool jedisPool = null;

    private JedisUtil(){}

    public static JedisUtil getInstance() {
        return RedisUtilHolder.instance;
    }

    public static void setJedisPool(JedisPool jedisPool) {
        JedisUtil.jedisPool = jedisPool;
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

    public void expire(String key, int seconds){
        Jedis jedis = getJedis();
        jedis.expire(key, seconds);
        closeJedis(jedis);
    }


}
