package com.qiqi.msjapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.qiqi.commonlib.common.Constants;
import com.qiqi.msjapi.service.ProductService;
import com.qiqi.msjmapper.entity.PCategory;
import com.qiqi.msjmapper.entity.Product;
import com.qiqi.msjmapper.enums.PCategoryLevel;
import com.qiqi.msjmapper.enums.ProductStatus;
import com.qiqi.msjmapper.mapper.PCategoryCustomMapper;
import com.qiqi.msjmapper.mapper.ProductCustomMapper;
import com.qiqi.msjmapper.pojo.ProductDetail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private PCategoryCustomMapper pCategoryCustomMapper;
    @Resource
    private ProductCustomMapper productCustomMapper;

    @Override
    public List<PCategory> getPCategory(Integer fid) {
        if(fid == 0){
            return pCategoryCustomMapper.queryByLevel(PCategoryLevel.ONE.getCode());
        }else {
            return pCategoryCustomMapper.queryByFid(fid);
        }
    }

    @Override
    public List<Product> getProductList(Integer categoryId, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<Product> productList = productCustomMapper.queryProductByCategoryId(categoryId, ProductStatus.SHELF.getCode());
        for(Product product : productList){
            product.setImage(Constants.URL_PREFIX + product.getImage());
        }
        return productList;
    }

    @Override
    public ProductDetail getProductDetail(Integer id) {
        ProductDetail productDetail = productCustomMapper.queryProductDetail(id);
        List<String> images = new ArrayList<>();
        for(String image : productDetail.getImages()){
            image = Constants.URL_PREFIX + image;
            images.add(image);
        }
        productDetail.setImages(images);
        return productDetail;
    }
}
