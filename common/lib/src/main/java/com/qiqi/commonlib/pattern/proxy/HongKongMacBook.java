package com.qiqi.commonlib.pattern.proxy;

public class HongKongMacBook implements MacBook{
    @Override
    public void buyIt() {
        System.out.println("这是港版mac");
    }
}
