package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.entity.BackPermission;

public interface BackPermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BackPermission record);

    int insertSelective(BackPermission record);

    BackPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BackPermission record);

    int updateByPrimaryKey(BackPermission record);
}