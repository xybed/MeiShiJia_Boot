package com.qiqi.commonlib.pattern.responsibility;

/**
 * 抽象处理者
 */
public abstract class Handler {
    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    abstract String handleRequest(int type, String user);
}
