package com.qiqi.commonlib.pattern.visitor;

/**
 * 抽象元素
 */
public interface Element {
    void accept(Visitor visitor);
}
