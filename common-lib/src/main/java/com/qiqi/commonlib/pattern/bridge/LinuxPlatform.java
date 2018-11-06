package com.qiqi.commonlib.pattern.bridge;

public class LinuxPlatform extends Platform{

    public LinuxPlatform(Coder coder){
        this.coder = coder;
    }

    @Override
    public void program() {
        coder.type();
        System.out.println("使用linux平台");
    }
}
