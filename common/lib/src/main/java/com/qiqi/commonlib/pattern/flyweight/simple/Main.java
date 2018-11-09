package com.qiqi.commonlib.pattern.flyweight.simple;

public class Main {
    public static void main(String[] args){
        CustomerStringFactory factory = new CustomerStringFactory();
        CustomerString str = factory.factory(new Character('R'));
        str.opt("Real");

        str = factory.factory(new Character('B'));
        str.opt("Bar");

        str = factory.factory(new Character('R'));
        str.opt("Madrid");
    }
}
