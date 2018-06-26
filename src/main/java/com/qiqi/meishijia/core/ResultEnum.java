package com.qiqi.meishijia.core;

/**
 * 响应码枚举
 */
public enum ResultEnum {
    SUCCESS(0, "成功"),
    FAIL(-1, "失败"),
    PARAM_ERROR(-2, "参数错误"),
    SIGN_FAIL(401, "认证失败"),//（签名错误）
    NOT_FOUND(404, "接口不存在"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    TOKEN_ERROR(-99, "登录过期"),
    //用户相关
    REGISTERED(1001, "该用户已注册过"),
    REGISTER_FAIL(1002, "注册失败，请稍后再试"),
    LOGIN_ERROR(1003, "用户名或密码不正确"),
    LOGIN_FAIL(1004, "登录失败，请稍后再试"),
    MODIFY_FAIL(1005, "修改失败，请稍后再试"),
    ;

    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
