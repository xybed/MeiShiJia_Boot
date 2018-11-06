package com.qiqi.commonlib.pattern.bridge;

public class WindowsPlatform extends Platform{

    public WindowsPlatform(Coder coder){
        this.coder = coder;
    }

    @Override
    public void program() {
        coder.type();
        System.out.println("使用windows平台");
    }
}
