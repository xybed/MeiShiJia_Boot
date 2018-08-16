package com.qiqi.msjapi.service;

import com.qiqi.msjmapper.entity.PCategory;
import com.qiqi.msjmapper.entity.Product;

import java.util.List;

public interface ProductService {
    List<PCategory> getPCategory(Integer fid);

    List<Product> getProductList(Integer categoryId, Integer pageIndex, Integer pageSize);
}
