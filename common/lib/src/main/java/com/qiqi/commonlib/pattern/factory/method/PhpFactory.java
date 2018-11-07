package com.qiqi.commonlib.pattern.factory.method;

public class PhpFactory implements IFactory{
    @Override
    public ICode getCodeSkill() {
        return new PhpCode();
    }
}
