package com.qiqi.commonlib.pattern.command;

/**
 * 请求调用者
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void calling(){
        command.exec();
    }
}
