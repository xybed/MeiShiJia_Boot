package com.qiqi.msjorder.controller;

import com.qiqi.commonlib.common.Result;
import com.qiqi.commonlib.common.ResultEnum;
import com.qiqi.commonlib.common.ResultGenerator;
import com.qiqi.msjmapper.entity.ReceivingAddress;
import com.qiqi.msjorder.service.OrderService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping(value = "/addresses", method = RequestMethod.GET)
    public Result getReceivingAddress(@RequestParam("user_id") Integer userId){
        if(StringUtils.isEmpty(userId)){
            return ResultGenerator.genFailResult(ResultEnum.PARAM_ERROR);
        }
        return ResultGenerator.genSuccessResult(orderService.getReceivingAddress(userId));
    }

    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public Result addReceivingAddress(@RequestBody ReceivingAddress receivingAddress){
        if(StringUtils.isEmpty(receivingAddress.getName()) ||
                StringUtils.isEmpty(receivingAddress.getPhone()) ||
                StringUtils.isEmpty(receivingAddress.getProvince()) ||
                StringUtils.isEmpty(receivingAddress.getCity()) ||
                StringUtils.isEmpty(receivingAddress.getAddress())){
            return ResultGenerator.genFailResult(ResultEnum.PARAM_ERROR);
        }
        orderService.addReceivingAddress(receivingAddress);
        return ResultGenerator.genSuccessResult("添加成功");
    }

    @RequestMapping(value = "/address", method = RequestMethod.PUT)
    public Result updateReceivingAddress(@RequestBody ReceivingAddress receivingAddress){
        if(StringUtils.isEmpty(receivingAddress.getId())){
            return ResultGenerator.genFailResult(ResultEnum.PARAM_ERROR);
        }
        orderService.updateReceivingAddress(receivingAddress);
        return ResultGenerator.genSuccessResult("更新成功");
    }

    @RequestMapping(value = "/addresses/{id}", method = RequestMethod.DELETE)
    public Result deleteReceivingAddress(@PathVariable Integer id){
        if(StringUtils.isEmpty(id)){
            return ResultGenerator.genFailResult(ResultEnum.PARAM_ERROR);
        }
        orderService.deleteReceivingAddress(id);
        return ResultGenerator.genSuccessResult("删除成功");
    }
}
