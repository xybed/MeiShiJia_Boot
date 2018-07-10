package com.qiqi.meishijia.mapper;

import com.qiqi.meishijia.pojo.FootballPlayerCustom;

import java.util.List;

public interface FootballPlayerCustomMapper {
    List<FootballPlayerCustom> selectByTeamId(Integer teamId);
}
