package com.qiqi.commonlib.pattern.bridge;

public class Main {
    public static void main(String[] args){
        Coder javaCoder = new JavaCoder();
        Coder phpCoder = new PhpCoder();
        Platform platform = new WindowsPlatform(javaCoder);
        Company company = new GoogleCompany(platform);
        company.work();

        platform = new LinuxPlatform(phpCoder);
        company = new AliCompany(platform);
        company.work();
        //上面的例子只写了这两种，还可以有各种组合
    }
}
