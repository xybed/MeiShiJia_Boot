package com.qiqi.msjorder.controller;

import com.alibaba.fastjson.JSONArray;
import com.qiqi.commonconfig.common.Result;
import com.qiqi.commonconfig.common.ResultEnum;
import com.qiqi.commonconfig.common.ResultGenerator;
import com.qiqi.msjmapper.entity.ShoppingCart;
import com.qiqi.msjorder.service.ShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@RestController
public class ShoppingCartController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

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

    @RequestMapping(value = "/shopping/cart", method = RequestMethod.DELETE)
    public Result deleteShoppingCart(String json){
        try {
            json = URLDecoder.decode(json, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            json = "[]";
        }
        List<Integer> idList = JSONArray.parseArray(json, Integer.class);
        if(idList == null || idList.size() <= 0){
            return ResultGenerator.genFailResult(ResultEnum.PARAM_ERROR);
        }
        shoppingCartService.deleteShoppingCart(idList);
        return ResultGenerator.genSuccessResult("删除成功");
    }

    @RequestMapping(value = "/shopping/cart/invalid", method = RequestMethod.PUT)
    public Result clearInvalidShoppingCart(@RequestBody ShoppingCart shoppingCart){
        if(StringUtils.isEmpty(shoppingCart.getUserId())){
            return ResultGenerator.genFailResult(ResultEnum.PARAM_ERROR);
        }
        shoppingCartService.clearInvalidShoppingCart(shoppingCart.getUserId());
        return ResultGenerator.genSuccessResult("清除成功");
    }
}
