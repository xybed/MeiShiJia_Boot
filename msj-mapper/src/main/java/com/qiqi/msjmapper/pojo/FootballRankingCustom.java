package com.qiqi.msjmapper.pojo;

import com.qiqi.msjmapper.entity.FootballRanking;

import java.io.Serializable;

public class FootballRankingCustom extends FootballRanking implements Serializable {
    private Integer leagueId;
    private String logo;
    private String name;

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
