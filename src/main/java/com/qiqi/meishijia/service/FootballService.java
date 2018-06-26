package com.qiqi.meishijia.service;

import com.qiqi.meishijia.pojo.FootballRankingCustom;

import java.util.List;

public interface FootballService {
    List<FootballRankingCustom> getRanking(Integer leagueId);
}
