package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.entity.PCategory;

public interface PCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PCategory record);

    int insertSelective(PCategory record);

    PCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PCategory record);

    int updateByPrimaryKey(PCategory record);
}