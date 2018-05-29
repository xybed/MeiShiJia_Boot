package com.qiqi.meishijia.model.request;

/**
 * 对应user模块的body请求参数
 */
public class UserReq {
    private String username;
    private String password;

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
}
