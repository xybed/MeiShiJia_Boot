package com.qiqi.msjback.controller;

import com.qiqi.commonlib.common.Result;
import com.qiqi.commonlib.common.ResultGenerator;
import com.qiqi.msjback.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    @RequestMapping(value = "/getLeftMenu", method = RequestMethod.POST)
    @ResponseBody
    public Result getLeftMenu(){
        return ResultGenerator.genSuccessResult(menuService.getLeftMenu());
    }
}
