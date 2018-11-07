package com.qiqi.commonlib.pattern.factory.method;

public class JavaFactory implements IFactory{
    @Override
    public ICode getCodeSkill() {
        return new JavaCode();
    }
}
