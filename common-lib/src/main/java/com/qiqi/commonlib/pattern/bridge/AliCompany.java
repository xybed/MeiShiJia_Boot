package com.qiqi.commonlib.pattern.bridge;

public class AliCompany extends Company{

    public AliCompany(Platform platform){
        this.platform = platform;
    }

    @Override
    public void work() {
        System.out.println("阿里公司的");
        platform.program();
    }
}
