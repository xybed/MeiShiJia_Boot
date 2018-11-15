package com.qiqi.msjorder.controller;

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
    public Result getShoppingCarts(@RequestParam("user_id") Integer userId){
        if(StringUtils.isEmpty(userId)){
            return ResultGenerator.genFailResult(ResultEnum.PARAM_ERROR);
        }
        return ResultGenerator.genSuccessResult(shoppingCartService.getShoppingCarts(userId));
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
