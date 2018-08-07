package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.pojo.BackMenuCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BackMenuCustomMapper {

    List<BackMenuCustom> queryMenuByFid(@Param("fid") Integer fid, @Param("userId") Integer userId, @Param("type") Integer type);
}