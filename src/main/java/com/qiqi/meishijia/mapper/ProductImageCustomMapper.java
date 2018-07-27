package com.qiqi.meishijia.mapper;

import com.qiqi.meishijia.model.ProductImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductImageCustomMapper {
    void batchInsert(@Param("list") List<ProductImage> list);
}