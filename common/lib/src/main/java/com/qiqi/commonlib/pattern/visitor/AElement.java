package com.qiqi.commonlib.pattern.visitor;

/**
 * 具体元素
 */
public class AElement implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationA(){
        System.out.println("AElement");
    }
}
