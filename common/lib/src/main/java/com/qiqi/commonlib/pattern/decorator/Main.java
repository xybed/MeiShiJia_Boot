package com.qiqi.commonlib.pattern.decorator;

public class Main {
    public static void main(String[] args){
        Coder coder = new JavaCoder();
        coder.skill();
        coder = new JavaDecorator(coder);
        coder.skill();
    }
}
