package com.qiqi.commonlib.pattern.prototype;

public class UserPrototype implements Cloneable{

    @Override
    protected UserPrototype clone() throws CloneNotSupportedException {
        return (UserPrototype) super.clone();
    }
}
