package com.qiqi.msjapi.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class AlipayPreCreate {
    private String code;

    private String msg;

    @JSONField(name = "out_trade_no")
    private String outTradeNo;

    @JSONField(name = "qr_code")
    private String qrCode;

    @JSONField(name = "sub_code")
    private String subCode;

    @JSONField(name = "sub_msg")
    private String subMsg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getSubMsg() {
        return subMsg;
    }

    public void setSubMsg(String subMsg) {
        this.subMsg = subMsg;
    }
}
