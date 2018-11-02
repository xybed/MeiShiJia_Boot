package com.qiqi.commonlib.pattern.singleton;

/**
 * 饿汉式
 * 被加载时候就实例化一个对象
 */
public class HungerSingleton {
    private static HungerSingleton singleton = new HungerSingleton();

    private HungerSingleton(){}

    public static HungerSingleton getInstance(){
        return singleton;
    }
}
