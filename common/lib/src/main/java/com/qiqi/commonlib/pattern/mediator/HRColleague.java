package com.qiqi.commonlib.pattern.mediator;

public class HRColleague extends Colleague{
    public HRColleague(String name, Mediator mediator) {
        super(name, mediator);
    }

    public void contact(String msg){
        mediator.contact(msg, this);
    }

    public void getMessage(String msg){
        System.out.println("HR#"+name+"#:"+msg);
    }
}
