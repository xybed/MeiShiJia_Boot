package com.qiqi.commonlib.pattern.interpreter;

/**
 * 终结符表达式
 */
public class Variable implements Expression{
    @Override
    public int interpret(Context context) {
        return context.lookupValue(this);
    }
}
