package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.entity.BackRole;

import java.util.List;

public interface BackRoleCustomMapper {
    List<BackRole> queryByUsername(String username);
}