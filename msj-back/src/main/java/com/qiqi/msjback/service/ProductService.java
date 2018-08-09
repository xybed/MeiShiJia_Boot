package com.qiqi.msjback.service;

import com.qiqi.msjmapper.entity.Product;
import com.qiqi.msjmapper.pojo.Pagination;

import java.util.Map;

public interface ProductService {
    Map queryProduct(Product product, Pagination grid);

    Product editQuery(Integer id);
}
