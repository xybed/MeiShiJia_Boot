package com.qiqi.commonlib.pattern.strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void language(){
        strategy.language();
    }
}
