package com.qiqi.msjmapper.mapper;

import com.qiqi.msjmapper.dto.ProductDto;
import com.qiqi.msjmapper.entity.Product;
import com.qiqi.msjmapper.pojo.ProductCustom;
import com.qiqi.msjmapper.dto.ProductDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCustomMapper {
    Product queryByUrl(String url);

    int insertSelective(Product record);

    List<ProductCustom> queryProduct(Product product);

    Product queryProductById(Integer id);

    List<ProductDto> queryProductByCategoryId(@Param("categoryId") Integer categoryId, @Param("status") Integer status);
    
    List<ProductDto> searchProduct(@Param("keyword") String keyword, @Param("status") Integer status);

    ProductDetail queryProductDetail(@Param("id") Integer id);
}