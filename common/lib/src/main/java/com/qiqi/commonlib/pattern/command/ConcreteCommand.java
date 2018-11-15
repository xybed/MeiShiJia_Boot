package com.qiqi.commonlib.pattern.command;

/**
 * 具体命令类
 */
public class ConcreteCommand implements Command{
    @Override
    public void exec() {
        Receiver receiver = new Receiver();
        receiver.action();
    }
}
