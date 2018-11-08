package com.qiqi.commonlib.pattern.decorator;

/**
 * ConcreteComponent（具体构件）
 */
public class JavaCoder implements Coder{
    @Override
    public void skill() {
        System.out.println("会java技能");
    }
}
