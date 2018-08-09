package com.qiqi.msjback.controller;

import com.alibaba.fastjson.JSON;
import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.multitype.GenericManageableCaptchaService;
import com.qiqi.commonlib.common.Result;
import com.qiqi.commonlib.common.ResultEnum;
import com.qiqi.commonlib.common.ResultGenerator;
import com.qiqi.msjmapper.pojo.BackUserCustom;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private GenericManageableCaptchaService captchaService;

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/main")
    public String mainPage() {
        return "main";
    }

    @RequestMapping("/403")
    public String forbidden(){
        return "403";
    }

    @PostMapping(value = "/authentication")
    @ResponseBody
    public Result authentication(String json, HttpServletRequest request){
        BackUserCustom user = JSON.parseObject(json, BackUserCustom.class);
        if(StringUtils.isEmpty(user.getUsername()) ||
                StringUtils.isEmpty(user.getPassword())){
            return ResultGenerator.genFailResult(ResultEnum.PARAM_ERROR);
        }else {
            boolean pass = checkVerifyCode(user, request);
            if(!pass){
                return ResultGenerator.genFailResult(ResultEnum.VERIFY_CODE_ERROR);
            }
        }
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        }catch (AccountException e){
            token.clear();
            return ResultGenerator.genFailResult(e.getMessage());
        }
        return ResultGenerator.genSuccessResult();
    }

    public boolean checkVerifyCode(BackUserCustom userCustom, HttpServletRequest request){
        String code = userCustom.getVerifyCode();
        if (StringUtils.isEmpty(code)) {
            return false;
        }
        //检查验证码
        String captchaId = request.getSession().getId();
        try {
            return captchaService.validateResponseForID(captchaId, code);
        } catch (CaptchaServiceException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }
}
