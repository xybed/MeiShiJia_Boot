package com.qiqi.msjapi.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class AlipayPreCreateBase {
    @JSONField(name = "alipay_trade_precreate_response")
    private AlipayPreCreate alipayTradePrecreateResponse;

    private String sign;

    public AlipayPreCreate getAlipayTradePrecreateResponse() {
        return alipayTradePrecreateResponse;
    }

    public void setAlipayTradePrecreateResponse(AlipayPreCreate alipayTradePrecreateResponse) {
        this.alipayTradePrecreateResponse = alipayTradePrecreateResponse;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
