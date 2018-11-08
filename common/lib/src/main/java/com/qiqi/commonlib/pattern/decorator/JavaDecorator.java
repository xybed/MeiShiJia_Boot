package com.qiqi.commonlib.pattern.decorator;

/**
 * ConcreteDecorator（具体装饰类）
 */
public class JavaDecorator extends Decorator{
    public JavaDecorator(Coder coder) {
        super(coder);
    }

    @Override
    public void skill() {
        super.skill();
        System.out.println("还会设计模式！");
    }
}
