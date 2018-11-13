package com.qiqi.msjproduct.service;

import com.qiqi.msjmapper.dto.ProductDto;
import com.qiqi.msjmapper.entity.PCategory;
import com.qiqi.msjmapper.entity.Product;
import com.qiqi.msjmapper.dto.ProductDetail;

import java.util.List;

public interface ProductService {
    List<PCategory> getPCategory(Integer fid);

    List<ProductDto> getProductList(Integer categoryId, Integer pageIndex, Integer pageSize);
    
    List<ProductDto> searchProductList(String keyword, Integer pageIndex, Integer pageSize);

    ProductDetail getProductDetail(Integer id);

    List<ProductDto> getProductShoppingCart(List<Integer> idList);

    Integer getProductStock(Integer id);
}
