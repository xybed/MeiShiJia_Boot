package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.entity.Product;
import com.qiqi.msjmapper.pojo.ProductCustom;

import java.util.List;

public interface ProductCustomMapper {
    Product queryByUrl(String url);

    int insertSelective(Product record);

    List<ProductCustom> queryProduct(Product product);

    Product queryProductById(Integer id);
}