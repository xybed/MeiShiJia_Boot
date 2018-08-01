package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.entity.ProductImage;

public interface ProductImageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductImage record);

    int insertSelective(ProductImage record);

    ProductImage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductImage record);

    int updateByPrimaryKey(ProductImage record);
}