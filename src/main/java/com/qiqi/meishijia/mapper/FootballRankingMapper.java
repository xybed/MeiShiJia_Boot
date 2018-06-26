package com.qiqi.meishijia.mapper;

import com.qiqi.meishijia.model.FootballRanking;

public interface FootballRankingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FootballRanking record);

    int insertSelective(FootballRanking record);

    FootballRanking selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FootballRanking record);

    int updateByPrimaryKey(FootballRanking record);
}