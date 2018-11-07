package com.qiqi.msjfootball.service;

import com.qiqi.msjmapper.pojo.FootballPlayerCustom;
import com.qiqi.msjmapper.pojo.FootballRankingCustom;

import java.util.List;

public interface FootballService {
    List<FootballRankingCustom> getRanking(Integer leagueId);

    List<FootballPlayerCustom> getTeam(Integer teamId);
}
