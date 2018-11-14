package com.qiqi.commonlib.pattern.strategy;

public class Main {
    public static void main(String[] args){
        Strategy strategy = new JavaStrategy();
        Context context = new Context(strategy);
        context.language();

        strategy = new PhpStrategy();
        context = new Context(strategy);
        context.language();
    }
}
