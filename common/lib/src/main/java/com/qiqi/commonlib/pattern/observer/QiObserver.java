package com.qiqi.commonlib.pattern.observer;

import java.util.Observable;
import java.util.Observer;

public class QiObserver implements Observer {

    public QiObserver(Observable o){
        o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("77爱佳佳："+((JiaObservable)o).getState());
    }
}
