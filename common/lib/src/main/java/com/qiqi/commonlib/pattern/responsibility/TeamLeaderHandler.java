package com.qiqi.commonlib.pattern.responsibility;

public class TeamLeaderHandler extends Handler{
    @Override
    String handleRequest(int type, String user) {
        String ret = "";
        if(type == Type.CODE_FORMAT){
            ret = user + "'s App CODE is OK!";
        }else {
            if(getHandler() != null){
                System.out.println("***Team Leader Handler***");
                ret = getHandler().handleRequest(type, user);
            }
        }
        return ret;
    }
}
