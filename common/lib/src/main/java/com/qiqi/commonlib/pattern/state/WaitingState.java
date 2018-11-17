package com.qiqi.commonlib.pattern.state;

public class WaitingState implements State {
    @Override
    public void handleState(String str) {
        System.out.println("State: waiting, str="+str);
    }
}
