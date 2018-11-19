package com.qiqi.commonlib.pattern.mediator;

public class JavaColleague extends Colleague{
    public JavaColleague(String name, Mediator mediator) {
        super(name, mediator);
    }

    public void contact(String msg){
        mediator.contact(msg, this);
    }

    public void getMessage(String msg){
        System.out.println("Java#"+name+"#:"+msg);
    }
}
