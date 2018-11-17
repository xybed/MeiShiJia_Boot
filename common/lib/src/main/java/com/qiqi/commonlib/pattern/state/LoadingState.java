package com.qiqi.commonlib.pattern.state;

public class LoadingState implements State{
    @Override
    public void handleState(String str) {
        System.out.println("State: loading, str="+str);
    }
}
