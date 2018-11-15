package com.qiqi.commonlib.pattern.command;

public class Main {
    public static void main(String[] args){
        Invoker invoker = new Invoker(new ConcreteCommand());
        invoker.calling();
    }
}
