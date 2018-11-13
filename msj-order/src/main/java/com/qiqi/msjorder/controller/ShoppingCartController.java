package com.qiqi.msjorder.controller;

import com.qiqi.commonconfig.common.Constants;
import com.qiqi.commonconfig.common.Result;
import com.qiqi.commonconfig.common.ResultEnum;
import com.qiqi.commonconfig.common.ResultGenerator;
import com.qiqi.msjmapper.entity.ShoppingCart;
import com.qiqi.msjorder.service.ShoppingCartService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/shopping/cart", method = RequestMethod.POST)
    public Result addShoppingCart(@RequestBody ShoppingCart shoppingCart){
        if(StringUtils.isEmpty(shoppingCart.getUserId()) ||
                StringUtils.isEmpty(shoppingCart.getProductId()) ||
                StringUtils.isEmpty(shoppingCart.getNum())){
            return ResultGenerator.genFailResult(ResultEnum.PARAM_ERROR);
        }
        shoppingCartService.addShoppingCart(shoppingCart);
        return ResultGenerator.genSuccessResult("添加成功");
    }
}
