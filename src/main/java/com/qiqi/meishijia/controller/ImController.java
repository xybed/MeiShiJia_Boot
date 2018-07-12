package com.qiqi.meishijia.controller;

import com.qiqi.meishijia.annotation.NeedLogin;
import com.qiqi.meishijia.core.Result;
import com.qiqi.meishijia.core.ResultEnum;
import com.qiqi.meishijia.core.ResultGenerator;
import com.qiqi.meishijia.service.ImService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/im")
public class ImController {

    @Resource
    private ImService imService;

    @NeedLogin
    @GetMapping("/contacts")
    public Result getContacts(@RequestParam("user_id") Integer userId){
        if(StringUtils.isEmpty(userId)){
            return ResultGenerator.genFailResult(ResultEnum.PARAM_ERROR);
        }
        return ResultGenerator.genSuccessResult(imService.getContacts(userId));
    }

    @NeedLogin
    @GetMapping("/contactsDetail")
    public Result getContactsDetail(@RequestParam("user_id") Integer userId, @RequestParam("friend_id") Integer friendId){
        if(StringUtils.isEmpty(userId) ||
                StringUtils.isEmpty(friendId)){
            return ResultGenerator.genFailResult(ResultEnum.PARAM_ERROR);
        }
        return ResultGenerator.genSuccessResult(imService.getContactsDetail(userId, friendId));
    }
}
