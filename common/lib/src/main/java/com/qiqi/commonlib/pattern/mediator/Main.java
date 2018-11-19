package com.qiqi.commonlib.pattern.mediator;

public class Main {
    public static void main(String[] args){
        ConcreteMediator mediator = new ConcreteMediator();
        HRColleague hr = new HRColleague("人事", mediator);
        JavaColleague java = new JavaColleague("程序员", mediator);

        mediator.setHr(hr);
        mediator.setJava(java);

        hr.contact("我是人事");
        java.contact("我吃柠檬");
    }
}
