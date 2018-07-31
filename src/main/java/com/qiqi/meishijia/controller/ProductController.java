package com.qiqi.meishijia.controller;

import com.qiqi.meishijia.core.Result;
import com.qiqi.meishijia.core.ResultGenerator;
import com.qiqi.meishijia.service.ProductService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @RequestMapping(value = "/category/{fid}", method = RequestMethod.GET)
    public Result getPCategory(@PathVariable Integer fid){
        if(fid == null)
            fid = 0;
        return ResultGenerator.genSuccessResult(productService.getPCategory(fid));
    }
}
