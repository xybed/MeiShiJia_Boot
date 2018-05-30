package com.qiqi.meishijia.controller;
import com.qiqi.meishijia.core.Result;
import com.qiqi.meishijia.core.ResultGenerator;
import com.qiqi.meishijia.model.UserToken;
import com.qiqi.meishijia.service.UserTokenService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by 77 on 2018/05/30.
*/
@RestController
@RequestMapping("/user/token")
public class UserTokenController {
    @Resource
    private UserTokenService userTokenService;

    @PostMapping("/add")
    public Result add(UserToken userToken) {
        userTokenService.save(userToken);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        userTokenService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(UserToken userToken) {
        userTokenService.update(userToken);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        UserToken userToken = userTokenService.findById(id);
        return ResultGenerator.genSuccessResult(userToken);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserToken> list = userTokenService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
