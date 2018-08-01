package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.entity.ProductImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductImageCustomMapper {
    void batchInsert(@Param("list") List<ProductImage> list);
}