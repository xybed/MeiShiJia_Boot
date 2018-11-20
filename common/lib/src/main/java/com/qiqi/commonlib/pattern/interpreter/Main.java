package com.qiqi.commonlib.pattern.interpreter;

public class Main {
    public static void main(String[] args){
        Context context = new Context();
        Variable a = new Variable();
        Variable b = new Variable();

        context.addValue(a, 7);
        context.addValue(b, 23);

        Expression expression = new Add(a, b);
        System.out.println("result="+expression.interpret(context));
    }
}
