package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.entity.BackUser;

public interface BackUserCustomMapper {
    BackUser queryByUsername(String username);
}