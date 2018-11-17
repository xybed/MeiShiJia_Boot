package com.qiqi.commonlib.pattern.responsibility;

public class UIHandler extends Handler{
    @Override
    String handleRequest(int type, String user) {
        String ret = "";
        if(type == Type.UI_EFFECT){
            ret = user + "'s App UI is OK!";
        }else {
            if(getHandler() != null){
                System.out.println("***UI Handler***");
                ret = getHandler().handleRequest(type, user);
            }
        }
        return ret;
    }
}
