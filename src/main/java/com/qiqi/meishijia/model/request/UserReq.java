package com.qiqi.meishijia.model.request;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 对应user模块的body请求参数
 */
public class UserReq {
    private String username;
    private String password;
    @JSONField(name = "verify_code")
    private String verifyCode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
