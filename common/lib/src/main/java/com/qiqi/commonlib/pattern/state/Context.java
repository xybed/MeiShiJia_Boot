package com.qiqi.commonlib.pattern.state;

public class Context {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void request(String str){
        state.handleState(str);
    }
}
