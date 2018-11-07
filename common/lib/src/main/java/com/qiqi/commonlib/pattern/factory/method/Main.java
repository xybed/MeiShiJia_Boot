package com.qiqi.commonlib.pattern.factory.method;

public class Main {
    public static void main(String[] args){
        IFactory factory = new JavaFactory();
        ICode code = factory.getCodeSkill();
        code.coding();

        factory = new PhpFactory();
        code = factory.getCodeSkill();
        code.coding();
    }
}
