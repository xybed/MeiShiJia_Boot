package com.qiqi.commonlib.pattern.factory.abstrac;

public class PhpFactory implements IFactory{
    @Override
    public ICode getCodeSkill() {
        return new PhpCode();
    }

    @Override
    public IBook getBook() {
        return new PhpBook();
    }
}
