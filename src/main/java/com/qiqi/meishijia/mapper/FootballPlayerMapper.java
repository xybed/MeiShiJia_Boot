package com.qiqi.meishijia.mapper;

import com.qiqi.meishijia.model.FootballPlayer;

public interface FootballPlayerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FootballPlayer record);

    int insertSelective(FootballPlayer record);

    FootballPlayer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FootballPlayer record);

    int updateByPrimaryKey(FootballPlayer record);
}