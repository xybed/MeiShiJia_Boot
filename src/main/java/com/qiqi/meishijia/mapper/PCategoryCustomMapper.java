package com.qiqi.meishijia.mapper;

import com.qiqi.meishijia.model.PCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PCategoryCustomMapper {
    void batchInsert(@Param("list") List<PCategory> list);
}