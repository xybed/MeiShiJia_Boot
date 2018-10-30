package com.qiqi.msjapi;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JedisTest {
    private static final String IP = "127.0.0.1";
    private static final int PORT = 6379;
    private static Jedis jedis = null;

    @BeforeClass
    public static void init(){
        jedis = JedisUtil.getInstance().getJedis(IP, PORT);
    }

    @AfterClass
    public static void close(){
        JedisUtil.getInstance().closeJedis(jedis, IP, PORT);
    }

    @Test
    public void testKey(){
        jedis.set("wukong", "hi");
        System.out.println(jedis.exists("wukong"));
        Set<String> set = jedis.keys("*");
        System.out.println(set);
        jedis.del("wukong");
        System.out.println(jedis.exists("wukong"));
    }

    @Test
    public void testString(){
        jedis.flushDB();
        jedis.mset("wukong", "悟空", "zhangfei", "张飞", "baiqi", "白起");
        System.out.println(jedis.mget("wukong", "asd"));
    }

    @Test
    public void testList(){
        jedis.lpush("list", "皇马", "Hala", "Madrid");
        System.out.println("获取list的数据:"+jedis.lrange("list", 0, -1));// -1 表示列表的最后一个元素
    }

    @Test
    public void testSet(){
        jedis.sadd("sets", "123", "adfa", "faga");
        jedis.sadd("sets2", "123", "jfghj", "yuti");
        System.out.println(jedis.smembers("sets"));

        System.out.println("交集："+jedis.sinter("set", "set2"));
        System.out.println("并集："+jedis.sunion("set", "set2"));
        System.out.println("差集："+jedis.sdiff("set", "set2"));
    }

    @Test
    public void testSortSet(){
        Map<String, Double> map = new HashMap<>();
        map.put("皇马", 13d);
        map.put("巴萨", 5d);
        map.put("拜仁", 5d);
        map.put("A米", 7d);
        jedis.zadd("zset", map);
        System.out.println(jedis.zrange("zset", 0, -1));
        System.out.println("值："+jedis.zscore("zset", "皇马"));
    }

    @Test
    public void testHash(){
        Map<String, String> map = new HashMap<>();
        map.put("皇马", "RM");
        map.put("巴萨", "BC");
        map.put("拜仁", "BR");
        map.put("A米", "AM");
        jedis.hmset("hash", map);
        System.out.println(jedis.hgetAll("hash"));
    }
}
