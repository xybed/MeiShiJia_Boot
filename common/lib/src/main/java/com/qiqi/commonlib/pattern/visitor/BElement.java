package com.qiqi.commonlib.pattern.visitor;

public class BElement implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationB(){
        System.out.println("BElement");
    }
}
