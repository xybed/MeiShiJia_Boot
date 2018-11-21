package com.qiqi.msjorder.controller;

import com.alibaba.fastjson.JSONArray;
import com.qiqi.commonconfig.common.Constants;
import com.qiqi.commonconfig.common.Result;
import com.qiqi.commonconfig.common.ResultEnum;
import com.qiqi.commonconfig.common.ResultGenerator;
import com.qiqi.commonlib.utils.StringUtil;
import com.qiqi.msjmapper.dto.ShoppingCartDto;
import com.qiqi.msjmapper.entity.ShoppingCart;
import com.qiqi.msjmapper.pojo.OrderCustom;
import com.qiqi.msjmapper.pojo.ShoppingCartCustom;
import com.qiqi.msjorder.service.OrderService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public Result placeOrder(@RequestBody OrderCustom custom){
        List<ShoppingCartDto> shoppingCartDtoList = JSONArray.parseArray(custom.getJson(), ShoppingCartDto.class);
        if(StringUtils.isEmpty(shoppingCartDtoList) ||
                shoppingCartDtoList.size() <= 0 ||
                StringUtils.isEmpty(custom.getReceivingAddressId())){
            return ResultGenerator.genFailResult(ResultEnum.PARAM_ERROR);
        }
        return ResultGenerator.genSuccessResult(orderService.placeOrder(shoppingCartDtoList, custom.getReceivingAddressId()));
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public Result getOrderList(@RequestParam Integer userId, @RequestParam(required = false) Integer type,
                       @RequestParam(required = false) Integer pageIndex, @RequestParam(required = false) Integer pageSize){
        if(StringUtils.isEmpty(userId)){
            return ResultGenerator.genFailResult(ResultEnum.PARAM_ERROR);
        }
        if(StringUtils.isEmpty(pageIndex))
            pageIndex = Constants.PAGE_INDEX;
        if(StringUtils.isEmpty(pageSize))
            pageSize = Constants.PAGE_SIZE;
        return ResultGenerator.genSuccessResult(orderService.getOrderList(userId, type, pageIndex, pageSize));
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public Result getOrderDetail(@PathVariable Integer id){
        if(StringUtils.isEmpty(id)){
            return ResultGenerator.genFailResult(ResultEnum.PARAM_ERROR);
        }
        return ResultGenerator.genSuccessResult(orderService.getOrderDetail(id));
    }
}
