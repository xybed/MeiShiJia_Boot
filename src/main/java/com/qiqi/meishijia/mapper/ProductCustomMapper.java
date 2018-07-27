package com.qiqi.meishijia.mapper;

import com.qiqi.meishijia.model.Product;

public interface ProductCustomMapper {
    Product queryByUrl(String url);

    int insertSelective(Product record);
}