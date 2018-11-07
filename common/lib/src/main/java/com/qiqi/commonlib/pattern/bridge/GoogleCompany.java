package com.qiqi.commonlib.pattern.bridge;

public class GoogleCompany extends Company{

    public GoogleCompany(Platform platform){
        this.platform = platform;
    }

    @Override
    public void work() {
        System.out.println("Google公司的");
        platform.program();
    }
}
