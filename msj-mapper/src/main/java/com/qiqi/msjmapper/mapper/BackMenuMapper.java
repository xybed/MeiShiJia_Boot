package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.entity.BackMenu;

public interface BackMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BackMenu record);

    int insertSelective(BackMenu record);

    BackMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BackMenu record);

    int updateByPrimaryKey(BackMenu record);
}