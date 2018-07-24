package com.qiqi.meishijia.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class AlipayRefund {
    private String code;

    private String msg;

    @JSONField(name = "buyer_logon_id")
    private String buyerLogonId;

    @JSONField(name = "buyer_user_id")
    private String buyerUserId;

    @JSONField(name = "fund_change")
    private String fundChange;

    @JSONField(name = "gmt_refund_pay")
    private String gmtRefundPay;

    @JSONField(name = "out_trade_no")
    private String outTradeNo;

    @JSONField(name = "refund_detail_item_list")
    private String refundDetailItemList;

    @JSONField(name = "refund_fee")
    private String refundFee;

    @JSONField(name = "send_back_fee")
    private String sendBackFee;

    @JSONField(name = "trade_no")
    private String tradeNo;

    //失败的字段
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

    public String getBuyerLogonId() {
        return buyerLogonId;
    }

    public void setBuyerLogonId(String buyerLogonId) {
        this.buyerLogonId = buyerLogonId;
    }

    public String getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(String buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    public String getFundChange() {
        return fundChange;
    }

    public void setFundChange(String fundChange) {
        this.fundChange = fundChange;
    }

    public String getGmtRefundPay() {
        return gmtRefundPay;
    }

    public void setGmtRefundPay(String gmtRefundPay) {
        this.gmtRefundPay = gmtRefundPay;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getRefundDetailItemList() {
        return refundDetailItemList;
    }

    public void setRefundDetailItemList(String refundDetailItemList) {
        this.refundDetailItemList = refundDetailItemList;
    }

    public String getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(String refundFee) {
        this.refundFee = refundFee;
    }

    public String getSendBackFee() {
        return sendBackFee;
    }

    public void setSendBackFee(String sendBackFee) {
        this.sendBackFee = sendBackFee;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
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
