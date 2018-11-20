package com.qiqi.commonlib.pattern.visitor;

/**
 * 抽象访问者
 */
public interface Visitor {
    void visit(AElement aElement);
    void visit(BElement bElement);
}
