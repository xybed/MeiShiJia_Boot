package com.qiqi.commonconfig.common;

/**
 * 响应码枚举
 */
public enum ResultEnum {
    SUCCESS(0, "成功"),
    FAIL(-1, "失败"),
    PARAM_ERROR(-2, "参数错误"),
    VERIFY_CODE_ERROR(-3, "验证码错误"),
    OPERATE_ERROR(-5, "操作失败"),
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
    //文件相关
    IMAGE_FILE_NULL(2001, "图片文件为空"),
    IMAGE_SAVE_ERROR(2002, "保存图片失败"),
    APPLICATION_PATH_ERROR(2003, "项目路径获取失败"),
    //商品相关
    PRODUCT_STOCK_NOT_ENOUGH(3001, "库存不足"),
    //订单、购物车、收货地址相关
    SHOPPING_CART_COUNT_ERROR(4101, "购物车最多50件商品"),
    ADDRESS_COUNT_ERROR(4201, "收货地址最多10条"),
    //支付相关
    ALIPAY_ORDER_ERROR(5001, "支付宝下单异常"),
    ALIPAY_REFUND_ERROR(5002, "支付宝退款异常"),
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
