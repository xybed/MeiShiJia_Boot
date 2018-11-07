package com.qiqi.commonlib.pattern.prototype;

public class Main {
    public static void main(String[] args){
        ConcreteUserPrototype prototype = new ConcreteUserPrototype();
        prototype.printHashCode();
        for(int i=0;i<5;i++){
            try {
                ConcreteUserPrototype clone = (ConcreteUserPrototype) prototype.clone();
                clone.printHashCode();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }
}
