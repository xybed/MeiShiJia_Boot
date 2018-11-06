package com.qiqi.msjorder.controller;

import com.qiqi.commonlib.common.Constants;
import com.qiqi.commonlib.common.Result;
import com.qiqi.commonlib.common.ResultEnum;
import com.qiqi.commonlib.common.ResultGenerator;
import com.qiqi.msjorder.service.ShoppingCartService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ShoppingCartController {

    @Resource
    private ShoppingCartService shoppingCartService;

    @RequestMapping(value = "/shopping/carts", method = RequestMethod.GET)
    public Result getShoppingCarts(@RequestParam("user_id") Integer userId,
                       @RequestParam(name = "page_index", required = false) Integer pageIndex,
                       @RequestParam(name = "page_size", required = false) Integer pageSize){
        if(StringUtils.isEmpty(userId)){
            return ResultGenerator.genFailResult(ResultEnum.PARAM_ERROR);
        }
        if(pageIndex == null)
            pageIndex = Constants.PAGE_INDEX;
        if(pageSize == null)
            pageSize = Constants.PAGE_SIZE;
        return ResultGenerator.genSuccessResult(shoppingCartService.getShoppingCarts(userId, pageIndex, pageSize));
    }
}
