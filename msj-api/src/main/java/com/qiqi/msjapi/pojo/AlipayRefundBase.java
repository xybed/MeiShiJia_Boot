package com.qiqi.msjapi.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class AlipayRefundBase {
    @JSONField(name = "alipay_trade_refund_response")
    private AlipayRefund alipayTradeRefundResponse;

    private String sign;

    public AlipayRefund getAlipayTradeRefundResponse() {
        return alipayTradeRefundResponse;
    }

    public void setAlipayTradeRefundResponse(AlipayRefund alipayTradeRefundResponse) {
        this.alipayTradeRefundResponse = alipayTradeRefundResponse;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
