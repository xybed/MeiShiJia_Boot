package com.qiqi.msjback.service.impl;

import com.github.pagehelper.PageHelper;
import com.qiqi.msjback.service.ProductService;
import com.qiqi.msjmapper.entity.Product;
import com.qiqi.msjmapper.enums.ProductStatus;
import com.qiqi.msjmapper.mapper.ProductCustomMapper;
import com.qiqi.msjmapper.pojo.PageBean;
import com.qiqi.msjmapper.pojo.Pagination;
import com.qiqi.msjmapper.pojo.ProductCustom;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductCustomMapper productCustomMapper;

    @Override
    public Map queryProduct(Product product, Pagination grid) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(grid.getPageIndex()+1, grid.getPageSize());
        List<ProductCustom> productList = productCustomMapper.queryProduct(product);
        PageBean<ProductCustom> pageBean = new PageBean<>(productList);
        map.put("data", pageBean.getList());
        map.put("total", pageBean.getTotal());
        return map;
    }

    @Override
    public Product editQuery(Integer id) {
        return productCustomMapper.queryProductById(id);
    }

}
