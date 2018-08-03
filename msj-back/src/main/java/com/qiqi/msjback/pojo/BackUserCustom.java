package com.qiqi.msjback.pojo;

import com.qiqi.msjmapper.entity.BackUser;

public class BackUserCustom extends BackUser {

    private String verifyCode;

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
