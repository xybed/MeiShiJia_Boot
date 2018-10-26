package com.qiqi.msjapi.controller;

import com.qiqi.commonlib.annotation.NeedLogin;
import com.qiqi.commonlib.common.Result;
import com.qiqi.commonlib.common.ResultEnum;
import com.qiqi.commonlib.common.ResultGenerator;
import com.qiqi.msjmapper.entity.RelationChain;
import com.qiqi.msjapi.service.ImService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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

    @NeedLogin
    @PostMapping("/modifyRemark")
    public Result modifyRemark(@RequestBody RelationChain relationChain){
        if(StringUtils.isEmpty(relationChain.getUserId()) ||
                StringUtils.isEmpty(relationChain.getFriendId()) ||
                StringUtils.isEmpty(relationChain.getRemark())){
            return ResultGenerator.genFailResult(ResultEnum.PARAM_ERROR);
        }
        imService.modifyRemark(relationChain);
        return ResultGenerator.genSuccessResult("修改成功");
    }
}
