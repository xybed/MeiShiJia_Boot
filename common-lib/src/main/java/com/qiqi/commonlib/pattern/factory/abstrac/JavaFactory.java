package com.qiqi.commonlib.pattern.factory.abstrac;

public class JavaFactory implements IFactory{
    @Override
    public ICode getCodeSkill() {
        return new JavaCode();
    }

    @Override
    public IBook getBook() {
        return new JavaBook();
    }
}
