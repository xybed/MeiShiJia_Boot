package com.qiqi.commonlib.pattern.builder;

public class Team {
    private String boss;
    private String player;
    private String ground;
    private String home;

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getGround() {
        return ground;
    }

    public void setGround(String ground) {
        this.ground = ground;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    @Override
    public String toString() {
        return "Team{" +
                "boss='" + boss + '\'' +
                ", player='" + player + '\'' +
                ", ground='" + ground + '\'' +
                ", home='" + home + '\'' +
                '}';
    }
}
