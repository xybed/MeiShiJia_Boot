package com.qiqi.commonlib.pattern.proxy;

public class Main {
    public static void main(String[] args){
        MacBook macBook = new ProxyMacBook();
        macBook.buyIt();
    }
}
