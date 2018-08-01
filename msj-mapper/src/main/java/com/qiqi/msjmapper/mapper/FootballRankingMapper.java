package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.entity.FootballRanking;

public interface FootballRankingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FootballRanking record);

    int insertSelective(FootballRanking record);

    FootballRanking selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FootballRanking record);

    int updateByPrimaryKey(FootballRanking record);
}