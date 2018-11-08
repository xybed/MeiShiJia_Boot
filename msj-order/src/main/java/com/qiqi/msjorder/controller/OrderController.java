package com.qiqi.msjorder.controller;

import com.qiqi.msjorder.service.OrderService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;


}
