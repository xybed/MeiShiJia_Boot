package com.qiqi.commonlib.pattern.decorator;

/**
 * Decorator（抽象装饰类）
 */
public class Decorator implements Coder{
    private Coder coder;

    public Decorator(Coder coder) {
        this.coder = coder;
    }

    @Override
    public void skill(){
        coder.skill();
    }
}
