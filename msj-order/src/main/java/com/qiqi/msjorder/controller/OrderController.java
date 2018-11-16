package com.qiqi.msjorder.controller;

import com.alibaba.fastjson.JSONArray;
import com.qiqi.commonconfig.common.Result;
import com.qiqi.commonconfig.common.ResultEnum;
import com.qiqi.commonconfig.common.ResultGenerator;
import com.qiqi.msjmapper.dto.ShoppingCartDto;
import com.qiqi.msjmapper.entity.ShoppingCart;
import com.qiqi.msjmapper.pojo.OrderCustom;
import com.qiqi.msjmapper.pojo.ShoppingCartCustom;
import com.qiqi.msjorder.service.OrderService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public Result order(@RequestBody OrderCustom custom){
        List<ShoppingCartDto> shoppingCartDtoList = JSONArray.parseArray(custom.getJson(), ShoppingCartDto.class);
        if(StringUtils.isEmpty(shoppingCartDtoList) ||
                shoppingCartDtoList.size() <= 0 ||
                StringUtils.isEmpty(custom.getReceivingAddressId())){
            return ResultGenerator.genFailResult(ResultEnum.PARAM_ERROR);
        }
        orderService.order(shoppingCartDtoList, custom.getReceivingAddressId());
        return ResultGenerator.genSuccessResult("下单成功");
    }
}
