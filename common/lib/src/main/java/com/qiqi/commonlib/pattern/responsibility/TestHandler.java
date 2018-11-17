package com.qiqi.commonlib.pattern.responsibility;

public class TestHandler extends Handler{
    @Override
    String handleRequest(int type, String user) {
        String ret = "";
        if(type == Type.TEST_PROJECT){
            ret = user + "'s App Test is OK!";
        }else {
            if(getHandler() != null){
                System.out.println("***Test Handler***");
                ret = getHandler().handleRequest(type, user);
            }
        }
        return ret;
    }
}
