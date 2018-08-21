package com.qiqi.msjapi.service;

import com.qiqi.msjmapper.entity.PCategory;
import com.qiqi.msjmapper.entity.Product;
import com.qiqi.msjmapper.pojo.ProductDetail;

import java.util.List;

public interface ProductService {
    List<PCategory> getPCategory(Integer fid);

    List<Product> getProductList(Integer categoryId, Integer pageIndex, Integer pageSize);
    
    List<Product> searchProductList(String keyword, Integer pageIndex, Integer pageSize);

    ProductDetail getProductDetail(Integer id);
}
