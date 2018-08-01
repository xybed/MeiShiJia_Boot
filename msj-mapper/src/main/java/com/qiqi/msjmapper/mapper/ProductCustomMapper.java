package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.entity.Product;

public interface ProductCustomMapper {
    Product queryByUrl(String url);

    int insertSelective(Product record);
}