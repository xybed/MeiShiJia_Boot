package com.qiqi.msjapi.controller;

import com.qiqi.commonlib.common.Result;
import com.qiqi.commonlib.common.ResultEnum;
import com.qiqi.commonlib.common.ResultGenerator;
import com.qiqi.msjapi.common.Constants;
import com.qiqi.msjapi.service.ProductService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.GET)
    public Result getProductList(@RequestParam("category_id") Integer categoryId,
                     @RequestParam("page_index") Integer pageIndex, @RequestParam("page_size") Integer pageSize){
        if(StringUtils.isEmpty(categoryId)){
            return ResultGenerator.genFailResult(ResultEnum.PARAM_ERROR);
        }
        if(pageIndex == null)
            pageIndex = Constants.PAGE_INDEX;
        if(pageSize == null)
            pageSize = Constants.PAGE_SIZE;
        return ResultGenerator.genSuccessResult(productService.getProductList(categoryId, pageIndex, pageSize));
    }
}
