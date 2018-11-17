package com.qiqi.commonlib.pattern.state;

public class ErrorState implements State{
    @Override
    public void handleState(String str) {
        System.out.println("State: error, str="+str);
    }
}
