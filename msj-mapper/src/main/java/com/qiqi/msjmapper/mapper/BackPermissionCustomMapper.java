package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.entity.BackPermission;

import java.util.List;

public interface BackPermissionCustomMapper {
    List<BackPermission> queryByUsername(String username);
}