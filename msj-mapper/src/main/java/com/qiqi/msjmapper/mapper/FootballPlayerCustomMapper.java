package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.pojo.FootballPlayerCustom;

import java.util.List;

public interface FootballPlayerCustomMapper {
    List<FootballPlayerCustom> selectByTeamId(Integer teamId);
}
