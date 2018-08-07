package com.qiqi.msjback.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.qiqi.msjback.service.ProductService;
import com.qiqi.msjmapper.entity.Product;
import com.qiqi.msjmapper.mapper.ProductCustomMapper;
import com.qiqi.msjmapper.pojo.PageBean;
import com.qiqi.msjmapper.pojo.Pagination;
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
//        PageHelper.startPage(grid.getPageIndex()+1, grid.getPageSize());
        List<Product> productList = productCustomMapper.queryProduct(product);
//        PageBean<Product> pageBean = new PageBean<>(productList);
        map.put("data", productList);
        map.put("total", 10);
        return map;
    }
}
