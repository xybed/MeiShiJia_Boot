package com.qiqi.commonlib.pattern.visitor;

/**
 * 具体访问者
 */
public class AVisitor implements Visitor{
    @Override
    public void visit(AElement aElement) {
        aElement.operationA();
    }

    @Override
    public void visit(BElement bElement) {
        bElement.operationB();
    }
}
