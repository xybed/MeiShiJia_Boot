package com.qiqi.msjmapper.pojo;

import com.qiqi.msjmapper.entity.Product;
import com.qiqi.msjmapper.enums.ProductStatus;

public class ProductCustom extends Product {
    private ProductStatus productStatus;

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(ProductStatus productStatus) {
        this.productStatus = productStatus;
    }
}
