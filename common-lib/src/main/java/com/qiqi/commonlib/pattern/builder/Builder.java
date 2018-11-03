package com.qiqi.commonlib.pattern.builder;

public interface Builder {
    void buildBoss(String boss);
    void buildPlayer(String player);
    void buildGround(String ground);
    void buildHome(String home);

    Team getTeam();
}
