package com.qiqi.commonlib.pattern.proxy;

public class ProxyMacBook implements MacBook{
    @Override
    public void buyIt() {
        HongKongMacBook macBook = new HongKongMacBook();
        macBook.buyIt();
    }
}
