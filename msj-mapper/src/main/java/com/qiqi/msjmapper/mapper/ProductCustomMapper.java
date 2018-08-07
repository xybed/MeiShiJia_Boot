package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.entity.Product;

import java.util.List;

public interface ProductCustomMapper {
    Product queryByUrl(String url);

    int insertSelective(Product record);

    List<Product> queryProduct(Product product);
}