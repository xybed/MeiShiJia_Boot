package com.qiqi.meishijia.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiqi.meishijia.core.Result;
import com.qiqi.meishijia.core.ResultGenerator;
import com.qiqi.meishijia.model.User;
import com.qiqi.meishijia.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by 77 on 2018/05/25.
*/
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        Integer result = userService.register(user.getUsername(), user.getPassword(), user.getVerifyCode());
        if(result == 1){
            return ResultGenerator.genSuccessResult("该用户注册过且密码相同，自动为您登录");
        }else if(result == 2){
            return ResultGenerator.genSuccessResult("注册成功");
        }else {
            return ResultGenerator.genFailResult("注册失败");
        }
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        user = userService.login(user.getUsername(), user.getPassword());
        return ResultGenerator.genSuccessResult(user);
    }

    @PostMapping("/logout")
    public Result logout(@RequestHeader String token){

        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<User> list = userService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

}
