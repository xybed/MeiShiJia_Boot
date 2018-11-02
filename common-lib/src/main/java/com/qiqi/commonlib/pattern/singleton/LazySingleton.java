package com.qiqi.commonlib.pattern.singleton;

/**
 * 懒汉式（线程对象不唯一不安全）
 * 在调用取得实例方法的时候才会实例化对象
 */
public class LazySingleton {
    private static LazySingleton singleton;

    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if(singleton == null)
            singleton = new LazySingleton();
        return singleton;
    }
}
