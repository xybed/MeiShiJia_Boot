package com.qiqi.msjback.controller;

import com.alibaba.fastjson.JSON;
import com.qiqi.commonlib.common.Result;
import com.qiqi.commonlib.common.ResultGenerator;
import com.qiqi.msjback.service.ProductService;
import com.qiqi.msjmapper.entity.Product;
import com.qiqi.msjmapper.pojo.Pagination;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping
    public String productPage(){
        return "/product/productList";
    }

    @GetMapping("/addEditPage")
    public String productAddEditPage() {
        return "product/productAddEdit";
    }

    @RequestMapping(value = "/queryProduct")
    @ResponseBody
    public Map queryProduct(String json, Pagination grid){
        Product custom = JSON.parseObject(json, Product.class);
        if(custom == null)
            custom = new Product();
        return productService.queryProduct(custom, grid);
    }

    @RequestMapping(value = "/editQuery")
    @ResponseBody
    public Product editQuery(Integer id){
        return productService.editQuery(id);
    }
}
