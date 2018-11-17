package com.qiqi.commonlib.pattern.responsibility;

public class PMHandler extends Handler{
    @Override
    String handleRequest(int type, String user) {
        String ret = "";
        if(type == Type.PUBLISH_APP){
            ret = user + "'s App can be publish!";
        }else {
            if(getHandler() != null){
                System.out.println("***PM Handler***");
                ret = getHandler().handleRequest(type, user);
            }
        }
        return ret;
    }
}
