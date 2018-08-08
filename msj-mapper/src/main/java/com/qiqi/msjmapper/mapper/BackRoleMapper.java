package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.entity.BackRole;

public interface BackRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BackRole record);

    int insertSelective(BackRole record);

    BackRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BackRole record);

    int updateByPrimaryKey(BackRole record);
}