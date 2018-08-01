package com.qiqi.msjapi.service.impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.jpay.alipay.AliPayApi;
import com.jpay.ext.kit.PaymentKit;
import com.jpay.weixin.api.WxPayApi;
import com.jpay.weixin.api.WxPayApiConfigKit;
import com.qiqi.commonlib.lib.utils.IPUtil;
import com.qiqi.msjapi.common.Constants;
import com.qiqi.msjapi.core.ResultEnum;
import com.qiqi.msjapi.core.ServiceException;
import com.qiqi.msjapi.pojo.AlipayNotify;
import com.qiqi.msjapi.pojo.AlipayPreCreateBase;
import com.qiqi.msjapi.pojo.AlipayRefundBase;
import com.qiqi.msjapi.pojo.WxpayResponse;
import com.qiqi.msjapi.service.CommonService;
import com.qiqi.msjapi.service.PayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class PayServiceImpl implements PayService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private CommonService commonService;

    @Value("${alipay.notifyUrl}")
    private String alipayNotifyUrl;
    @Value("${wxpay.appId}")
    private String wxpayAppId;
    @Value("${wxpay.mchId}")
    private String mchId;
    @Value("${wxpay.partnerKey}")
    private String partnerKey;
    @Value("${wxpay.certPath}")
    private String certPath;
    @Value("${wxpay.notifyUrl}")
    private String wxpayNotifyUrl;

    @Override
    public String alipayCreatePay(Integer orderId) {
        //TODO 查询订单信息

        AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
        model.setOutTradeNo("test123");
        model.setSubject("支付宝测试");
        model.setTotalAmount("0.01");
        model.setTimeoutExpress(Constants.ALIPAY_TIMEOUT_EXPRESS);

        try {
            String result = AliPayApi.tradePrecreatePay(model, alipayNotifyUrl);
            logger.info(result);
            AlipayPreCreateBase preCreateBase = JSON.parseObject(result, AlipayPreCreateBase.class);
            if(Constants.ALIPAY_SUCCESS.equals(preCreateBase.getAlipayTradePrecreateResponse().getCode())){
                //下单成功，返回二维码
                return preCreateBase.getAlipayTradePrecreateResponse().getQrCode();
            }else {
                //下单失败，抛出错误原因
                throw new ServiceException(preCreateBase.getAlipayTradePrecreateResponse().getSubMsg());
            }
        } catch (AlipayApiException e) {
            logger.error(e.getMessage());
            throw new ServiceException(ResultEnum.ALIPAY_ORDER_ERROR);
        }
    }

    @Override
    public String wxpayCreatePay(Integer orderId) {
        //TODO 查询订单信息

        Map<String, String> params = WxPayApiConfigKit.getWxPayApiConfig()
                .setBody("微信支付测试")
                .setAppId(wxpayAppId)
                .setSpbillCreateIp(IPUtil.getLocalHostLANAddress())
                .setTotalFee("1")
                .setTradeType(WxPayApi.TradeType.NATIVE) //NATIVE 扫码支付
                .setNotifyUrl(wxpayNotifyUrl)
                .setOutTradeNo("test123")
                .build();
        String xmlResult = WxPayApi.pushOrder(false, params);
        logger.info(xmlResult);
        Map<String, String> result = PaymentKit.xmlToMap(xmlResult);
        WxpayResponse response = JSON.parseObject(JSON.toJSONString(result), WxpayResponse.class);
        if(Constants.WXPAY_SUCCESS.equals(response.getReturnCode())){
            if(Constants.WXPAY_SUCCESS.equals(response.getResultCode())){
                //下单成功返回二维码
                return response.getCodeUrl();
            }else {
                throw new ServiceException(response.getErrCodeDes());
            }
        }else {
            throw new ServiceException(response.getReturnMsg());
        }
    }

    @Override
    public void alipayNotify(Map<String, String> params) {
        AlipayNotify alipayNotify = JSON.parseObject(JSON.toJSONString(params), AlipayNotify.class);
        //TODO 查询订单状态，根据订单状态做去重操作
    }

    @Override
    public void wxpayNotify(Map<String, String> params) {
        WxpayResponse wxpayResponse = JSON.parseObject(JSON.toJSONString(params), WxpayResponse.class);
        //TODO 查询订单状态，根据订单状态做去重操作
//        if(Constants.WXPAY_SUCCESS.equals(wxpayResponse.getReturnCode()) &&
//                Constants.WXPAY_SUCCESS.equals(wxpayResponse.getResultCode())){
//
//        }else {
//
//        }
    }

    @Override
    public void alipayRefund(Integer orderId) {
        //TODO 查询订单信息
        AlipayTradeRefundModel model = new AlipayTradeRefundModel();
        model.setOutTradeNo("test123");
        model.setRefundAmount("0.01");
        try {
            String result = AliPayApi.tradeRefund(model);
            AlipayRefundBase refundBase = JSON.parseObject(result, AlipayRefundBase.class);
            if(Constants.ALIPAY_SUCCESS.equals(refundBase.getAlipayTradeRefundResponse().getCode())){

            }else {
                throw new ServiceException(refundBase.getAlipayTradeRefundResponse().getSubMsg());
            }
        }catch (AlipayApiException e) {
            logger.error(e.getMessage());
            //TODO 更改流水
            throw new ServiceException(ResultEnum.ALIPAY_REFUND_ERROR);
        }
    }

    @Override
    public void wxpayRefund(Integer orderId) {
        //TODO 查询订单信息

        Map<String, String> params = new HashMap<String, String>();
        params.put("appid", wxpayAppId);
        params.put("mch_id", mchId);
        params.put("nonce_str", System.currentTimeMillis()+"");//随机字符串，不长于32位
        params.put("out_trade_no", "test123");
        params.put("out_refund_no", "test123");
        params.put("total_fee", "1");
        params.put("refund_fee", "1");
        params.put("sign", PaymentKit.createSign(params, partnerKey));
        String xmlResult = WxPayApi.orderRefund(false, params , commonService.getApplicationPath() + certPath, mchId);
        Map<String, String> result = PaymentKit.xmlToMap(xmlResult);
        WxpayResponse response = JSON.parseObject(JSON.toJSONString(result), WxpayResponse.class);
        if(Constants.WXPAY_SUCCESS.equals(response.getReturnCode())){
            if(Constants.WXPAY_SUCCESS.equals(response.getResultCode())){

            }else {
                throw new ServiceException(response.getErrCodeDes());
            }
        }else {
            throw new ServiceException(response.getReturnMsg());
        }
    }
}
