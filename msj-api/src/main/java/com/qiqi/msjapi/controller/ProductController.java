package com.qiqi.msjapi.controller;

import com.qiqi.commonlib.annotation.NeedLogin;
import com.qiqi.commonlib.common.Constants;
import com.qiqi.commonlib.common.Result;
import com.qiqi.commonlib.common.ResultEnum;
import com.qiqi.commonlib.common.ResultGenerator;
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

    @NeedLogin
    @RequestMapping(method = RequestMethod.GET)
    public Result getProductList(@RequestParam("category_id") Integer categoryId,
                     @RequestParam(name = "page_index", required = false) Integer pageIndex,
                     @RequestParam(name = "page_size", required = false) Integer pageSize){
        if(StringUtils.isEmpty(categoryId)){
            return ResultGenerator.genFailResult(ResultEnum.PARAM_ERROR);
        }
//        jedis = JedisUtil.getInstance().getJedis(ip, 6379);
//        System.out.println(jedis.get("token15606954708"));
//        JedisUtil.getInstance().closeJedis(jedis, ip, 6379);
        if(pageIndex == null)
            pageIndex = Constants.PAGE_INDEX;
        if(pageSize == null)
            pageSize = Constants.PAGE_SIZE;
        return ResultGenerator.genSuccessResult(productService.getProductList(categoryId, pageIndex, pageSize));
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Result searchProductList(@RequestParam("keyword") String keyword,
                    @RequestParam("page_index") Integer pageIndex, @RequestParam("page_size") Integer pageSize){
        if(StringUtils.isEmpty(keyword)){
            return ResultGenerator.genFailResult(ResultEnum.PARAM_ERROR);
        }
        if(pageIndex == null)
            pageIndex = Constants.PAGE_INDEX;
        if(pageSize == null)
            pageSize = Constants.PAGE_SIZE;
        return ResultGenerator.genSuccessResult(productService.searchProductList(keyword, pageIndex, pageSize));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getProductDetail(@PathVariable Integer id){
        if(StringUtils.isEmpty(id)){
            return ResultGenerator.genFailResult(ResultEnum.PARAM_ERROR);
        }
        return ResultGenerator.genSuccessResult(productService.getProductDetail(id));
    }
}
