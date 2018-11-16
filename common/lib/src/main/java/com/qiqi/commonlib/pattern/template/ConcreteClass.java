package com.qiqi.commonlib.pattern.template;

public class ConcreteClass extends AbstractClass{
    @Override
    protected void aMethod() {
        System.out.println("A方法");
    }

    @Override
    protected void bMethod() {
        super.bMethod();
        System.out.println("B方法");
    }
}
