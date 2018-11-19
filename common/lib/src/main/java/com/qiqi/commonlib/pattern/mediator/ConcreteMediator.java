package com.qiqi.commonlib.pattern.mediator;

public class ConcreteMediator extends Mediator{
    private HRColleague hr;
    private JavaColleague java;

    public HRColleague getHr() {
        return hr;
    }

    public void setHr(HRColleague hr) {
        this.hr = hr;
    }

    public JavaColleague getJava() {
        return java;
    }

    public void setJava(JavaColleague java) {
        this.java = java;
    }

    @Override
    void contact(String message, Colleague colleague) {
        if(colleague == hr){
            hr.getMessage(message);
        }else {
            java.getMessage(message);
        }
    }
}
