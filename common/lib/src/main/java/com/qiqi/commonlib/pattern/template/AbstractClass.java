package com.qiqi.commonlib.pattern.template;

/**
 * 抽象类
 */
public abstract class AbstractClass {

    protected abstract void aMethod();

    protected void bMethod(){

    }

    private void cMethod(){
        System.out.println("C方法");
    }

    public void templateMethod(){
        aMethod();
        bMethod();
        cMethod();
    }
}
