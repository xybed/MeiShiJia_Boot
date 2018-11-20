package com.qiqi.commonlib.pattern.interpreter;

/**
 * 非终结符表达式
 */
public class Add implements Expression{
    private Expression left,right;

    public Add(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context)+right.interpret(context);
    }

}
