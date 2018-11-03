package com.qiqi.commonlib.pattern.builder;

/**
 * 指挥者
 */
public class Director {
    private Builder builder = new TeamBuilder();

    public Team getHighTeam(){
        builder.buildBoss("佛洛伦蒂诺");
        builder.buildPlayer("C罗");
        builder.buildGround("伯纳乌");
        builder.buildHome("皇马");
        return builder.getTeam();
    }

    public Team getLowTeam(){
        builder.buildBoss("巴托梅乌");
        builder.buildPlayer("梅西");
        builder.buildGround("诺坎普");
        builder.buildHome("巴萨");
        return builder.getTeam();
    }
}
