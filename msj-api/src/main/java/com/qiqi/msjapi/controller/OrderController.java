package com.qiqi.msjapi.controller;

import com.qiqi.commonlib.common.Result;
import com.qiqi.commonlib.common.ResultEnum;
import com.qiqi.commonlib.common.ResultGenerator;
import com.qiqi.msjapi.annotation.NeedLogin;
import com.qiqi.msjapi.service.OrderService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @NeedLogin
    @RequestMapping(value = "/address", method = RequestMethod.GET)
    public Result getReceivingAddress(@RequestParam("user_id") Integer userId){
        if(StringUtils.isEmpty(userId)){
            return ResultGenerator.genFailResult(ResultEnum.PARAM_ERROR);
        }
        return ResultGenerator.genSuccessResult(orderService.getReceivingAddress(userId));
    }
}
