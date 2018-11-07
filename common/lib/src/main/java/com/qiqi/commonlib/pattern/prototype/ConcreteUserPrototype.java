package com.qiqi.commonlib.pattern.prototype;

public class ConcreteUserPrototype extends UserPrototype{
    public void printHashCode(){
        System.out.println("ConcreteUserPrototype HashCode:"+this.hashCode());
    }
}
