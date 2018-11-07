package com.qiqi.commonlib.pattern.singleton;

/**
 * 懒汉式(相对比较靠谱模式)
 * 在懒汉式的基础上，保证线程安全
 * 如果使用双重检查锁定来实现懒汉式单例类，需要在静态成员变量instance之前增加修饰符volatile，
 * 被volatile修饰的成员变量只能在JDK 1.5及以上版本中才能正确执行。
 * volatile关键字会屏蔽Java虚拟机所做的一些代码优化，会导致系统运行效率降低，
 * 所以这种写法的单例模式也不是一种牛叉的写法。
 */
public class SynSingleton {
    private static volatile SynSingleton singleton;

    private SynSingleton(){}

    public static SynSingleton getInstance(){
        if(singleton == null){
            synchronized (SynSingleton.class){
                if(singleton == null)
                    singleton = new SynSingleton();
            }
        }
        return singleton;
    }
}
