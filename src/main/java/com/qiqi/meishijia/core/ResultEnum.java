package com.qiqi.meishijia.core;

/**
 * 响应码枚举
 */
public enum ResultEnum {
    SUCCESS(0, "成功"),
    FAIL(-1, "失败"),
    UNAUTHORIZED(401, "认证失败"),//（签名错误）
    NOT_FOUND(404, "接口不存在"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误");

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
