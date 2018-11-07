package com.qiqi.msjpay.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class WxpayResponse {
    @JSONField(name = "return_code")
    private String returnCode;

    @JSONField(name = "return_msg")
    private String returnMsg;

    private String appid;

    @JSONField(name = "mch_id")
    private String mchId;

    @JSONField(name = "nonce_str")
    private String nonceStr;

    private String sign;

    @JSONField(name = "result_code")
    private String resultCode;

    @JSONField(name = "prepay_id")
    private String prepayId;

    @JSONField(name = "trade_type")
    private String tradeType;

    @JSONField(name = "code_url")
    private String codeUrl;

    //错误代码
    @JSONField(name = "err_code")
    private String errCode;

    @JSONField(name = "err_code_des")
    private String errCodeDes;

    //回调返回字段
    private String openid;

    @JSONField(name = "bank_type")
    private String bankType;

    @JSONField(name = "total_fee")
    private String totalFee;

    @JSONField(name = "cash_fee")
    private String cashFee;

    @JSONField(name = "transaction_id")
    private String transactionId;

    @JSONField(name = "out_trade_no")
    private String outTradeNo;

    @JSONField(name = "time_end")
    private String timeEnd;

    @JSONField(name = "attach")
    private String attach;

    @JSONField(name = "fee_type")
    private String feeType;

    @JSONField(name = "is_subscribe")
    private String isSubscribe;

    //退款返回字段
    @JSONField(name = "out_refund_no")
    private String outRefundNo;

    @JSONField(name = "refund_id")
    private String refundId;

    @JSONField(name = "refund_fee")
    private String refundFee;

    @JSONField(name = "settlement_refund_fee")
    private String settlementRefundFee;

    @JSONField(name = "cash_fee_type")
    private String cashFeeType;

    @JSONField(name = "cash_refund_fee")
    private String cashRefundFee;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public void setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getCashFee() {
        return cashFee;
    }

    public void setCashFee(String cashFee) {
        this.cashFee = cashFee;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getIsSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(String isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(String refundFee) {
        this.refundFee = refundFee;
    }

    public String getSettlementRefundFee() {
        return settlementRefundFee;
    }

    public void setSettlementRefundFee(String settlementRefundFee) {
        this.settlementRefundFee = settlementRefundFee;
    }

    public String getCashFeeType() {
        return cashFeeType;
    }

    public void setCashFeeType(String cashFeeType) {
        this.cashFeeType = cashFeeType;
    }

    public String getCashRefundFee() {
        return cashRefundFee;
    }

    public void setCashRefundFee(String cashRefundFee) {
        this.cashRefundFee = cashRefundFee;
    }
}
