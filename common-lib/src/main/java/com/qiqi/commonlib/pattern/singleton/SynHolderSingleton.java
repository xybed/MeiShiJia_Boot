package com.qiqi.commonlib.pattern.singleton;

/**
 * 懒汉式(靠谱模式)
 * 如下写法的亮点就在于这种写法使用了JVM本身机制保证线程安全问题；
 * 由于InstanceHolder是私有的，除了getInstance()之外没有办法访问它，
 * 因此它是懒汉式的（SynHolderSingleton.getInstance()就不会创建实例）
 * 自己理解：因为jvm的类加载机制，当要用到类的时候才加载，所以当调用getInstance的时候才用到了类，内存中才创建了一个对象实例
 * 同时读取实例的时候不会进行同步，没有性能缺陷；也不依赖JDK版本。
 */
public class SynHolderSingleton {
    private static class InstanceHolder{
        static final SynHolderSingleton INSTANCE = new SynHolderSingleton();
    }

    private SynHolderSingleton(){}

    public static SynHolderSingleton getInstance(){
        return InstanceHolder.INSTANCE;
    }
}
