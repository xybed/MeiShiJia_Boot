package com.qiqi.commonlib.pattern.interpreter;

/**
 * 抽象表达式
 */
public interface Expression {
    int interpret(Context context);
}
