package com.qiqi.commonlib.pattern.observer;

public class Main {
    public static void main(String[] args){
        JiaObservable observable = new JiaObservable();
        new QiObserver(observable);
        observable.setState("爱");
        observable.setState("很爱");
        observable.setState("非常爱");
    }
}
