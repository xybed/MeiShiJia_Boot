package com.qiqi.commonlib.pattern.state;

public class Main {
    public static void main(String[] args){
        Context context = new Context();
        State state = new WaitingState();
        context.setState(state);
        context.request("1");

        state = new LoadingState();
        context.setState(state);
        context.request("2");

        state = new FinishState();
        context.setState(state);
        context.request("3");

        state = new ErrorState();
        context.setState(state);
        context.request("4");
    }
}
