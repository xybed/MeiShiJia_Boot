package com.qiqi.commonlib.pattern.factory.abstrac;

public class Main {
    public static void main(String[] args){
        IFactory factory = new JavaFactory();
        ICode code = factory.getCodeSkill();
        IBook book = factory.getBook();
        code.coding();
        book.lookBook();

        factory = new PhpFactory();
        code = factory.getCodeSkill();
        book = factory.getBook();
        code.coding();
        book.lookBook();
    }
}
