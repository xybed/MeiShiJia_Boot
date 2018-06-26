package com.qiqi.meishijia.mapper;

import com.qiqi.meishijia.pojo.FootballRankingCustom;

import java.util.List;

public interface FootballRankingCustomMapper {
    List<FootballRankingCustom> queryRankingByLeagueId(Integer leagueId);
}
