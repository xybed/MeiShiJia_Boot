package com.qiqi.commonlib.pattern.builder;

public class TeamBuilder implements Builder{
    private Team team = new Team();

    @Override
    public void buildBoss(String boss) {
        team.setBoss(boss);
    }

    @Override
    public void buildPlayer(String player) {
        team.setPlayer(player);
    }

    @Override
    public void buildGround(String ground) {
        team.setGround(ground);
    }

    @Override
    public void buildHome(String home) {
        team.setHome(home);
    }

    @Override
    public Team getTeam() {
        return team;
    }
}
