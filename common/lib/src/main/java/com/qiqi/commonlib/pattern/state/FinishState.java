package com.qiqi.commonlib.pattern.state;

public class FinishState implements State{
    @Override
    public void handleState(String str) {
        System.out.println("State: finish, str="+str);
    }
}
