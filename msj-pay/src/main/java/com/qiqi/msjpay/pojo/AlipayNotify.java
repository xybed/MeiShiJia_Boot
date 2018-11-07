package com.qiqi.msjpay.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class AlipayNotify {
    @JSONField(name = "gmt_create")
    private String gmtCreate;

    private String charset;

    @JSONField(name = "seller_email")
    private String sellerEmail;

    private String subject;

    private String sign;

    @JSONField(name = "buyer_id")
    private String buyerId;

    @JSONField(name = "invoice_amount")
    private String invoiceAmount;

    @JSONField(name = "notify_id")
    private String notifyId;

    @JSONField(name = "fund_bill_list")
    private String fundBillList;

    @JSONField(name = "notify_type")
    private String notifyType;

    @JSONField(name = "trade_status")
    private String tradeStatus;

    @JSONField(name = "receipt_amount")
    private String receiptAmount;

    @JSONField(name = "app_id")
    private String appId;

    @JSONField(name = "buyer_pay_amount")
    private String buyerPayAmount;

    @JSONField(name = "sign_type")
    private String signType;

    @JSONField(name = "seller_id")
    private String sellerId;

    @JSONField(name = "gmt_payment")
    private String gmtPayment;

    @JSONField(name = "notify_time")
    private String notifyTime;

    private String version;

    @JSONField(name = "out_trade_no")
    private String outTradeNo;

    @JSONField(name = "total_amount")
    private String totalAmount;

    @JSONField(name = "trade_no")
    private String tradeNo;

    @JSONField(name = "auth_app_id")
    private String authAppId;

    @JSONField(name = "buyer_logon_id")
    private String buyerLogonId;

    @JSONField(name = "point_amount")
    private String pointAmount;

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(String notifyId) {
        this.notifyId = notifyId;
    }

    public String getFundBillList() {
        return fundBillList;
    }

    public void setFundBillList(String fundBillList) {
        this.fundBillList = fundBillList;
    }

    public String getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(String receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getBuyerPayAmount() {
        return buyerPayAmount;
    }

    public void setBuyerPayAmount(String buyerPayAmount) {
        this.buyerPayAmount = buyerPayAmount;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getGmtPayment() {
        return gmtPayment;
    }

    public void setGmtPayment(String gmtPayment) {
        this.gmtPayment = gmtPayment;
    }

    public String getNotifyTime() {
        return notifyTime;
    }

    public void setNotifyTime(String notifyTime) {
        this.notifyTime = notifyTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getAuthAppId() {
        return authAppId;
    }

    public void setAuthAppId(String authAppId) {
        this.authAppId = authAppId;
    }

    public String getBuyerLogonId() {
        return buyerLogonId;
    }

    public void setBuyerLogonId(String buyerLogonId) {
        this.buyerLogonId = buyerLogonId;
    }

    public String getPointAmount() {
        return pointAmount;
    }

    public void setPointAmount(String pointAmount) {
        this.pointAmount = pointAmount;
    }
}
