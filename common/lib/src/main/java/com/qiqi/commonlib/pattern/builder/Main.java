package com.qiqi.commonlib.pattern.builder;

public class Main {
    public static void main(String[] args){
        Director director = new Director();
        Team team = director.getHighTeam();
        System.out.println(team.toString());
        team = director.getLowTeam();
        System.out.println(team.toString());
    }
}
