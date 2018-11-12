package com.qiqi.commonlib.pattern.observer;

import java.util.Observable;

public class JiaObservable extends Observable {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        //设置一个内部标记变量，代表被观察者对象的状态发生了变化
        setChanged();
        //调用所有登记过的观察者对象的update()方法
        notifyObservers();
    }
}
