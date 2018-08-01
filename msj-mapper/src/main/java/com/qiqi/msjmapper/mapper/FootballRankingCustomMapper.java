package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.pojo.FootballRankingCustom;

import java.util.List;

public interface FootballRankingCustomMapper {
    List<FootballRankingCustom> queryRankingByLeagueId(Integer leagueId);
}
