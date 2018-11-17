package com.qiqi.commonlib.pattern.responsibility;

public class Main {
    public static void main(String[] args){
        Handler teamLeader = new TeamLeaderHandler();
        Handler ui = new UIHandler();
        Handler test = new TestHandler();
        Handler pm = new PMHandler();

        teamLeader.setHandler(ui);
        ui.setHandler(test);
        test.setHandler(pm);
        //都是从teamLeader处发起请求
        System.out.println(teamLeader.handleRequest(Type.CODE_FORMAT, "77"));
        System.out.println(teamLeader.handleRequest(Type.TEST_PROJECT, "77"));
    }
}
