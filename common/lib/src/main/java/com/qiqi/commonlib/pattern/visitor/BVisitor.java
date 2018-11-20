package com.qiqi.commonlib.pattern.visitor;

public class BVisitor implements Visitor{
    @Override
    public void visit(AElement aElement) {
        aElement.operationA();
    }

    @Override
    public void visit(BElement bElement) {
        bElement.operationB();
    }
}
