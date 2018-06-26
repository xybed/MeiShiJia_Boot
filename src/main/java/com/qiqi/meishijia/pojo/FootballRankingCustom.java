package com.qiqi.meishijia.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.qiqi.meishijia.model.FootballRanking;

import java.io.Serializable;

public class FootballRankingCustom extends FootballRanking implements Serializable {
    @JSONField(name = "league_id")
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
