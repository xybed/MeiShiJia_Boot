package com.qiqi.meishijia.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.jpay.alipay.AliPayApi;
import com.jpay.ext.kit.HttpKit;
import com.jpay.ext.kit.PaymentKit;
import com.jpay.weixin.api.WxPayApiConfigKit;
import com.qiqi.meishijia.core.Result;
import com.qiqi.meishijia.core.ResultGenerator;
import com.qiqi.meishijia.model.Order;
import com.qiqi.meishijia.service.PayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pay")
public class PayController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private PayService payService;

    @Value("${alipay.alipayPublicKey}")
    private String alipayPublicKey;
    @Value("${alipay.charset}")
    private String charset;
    @Value("${alipay.signType}")
    private String signType;

    @RequestMapping(value = "/alipay/qrcode", method = RequestMethod.POST)
    public Result alipayQRCode(@RequestBody Order order){
        return ResultGenerator.genSuccessResult(payService.alipayCreatePay(order.getId()));
    }

    @RequestMapping(value = "/wxpay/qrcode", method = RequestMethod.POST)
    public Result wxpayQRCode(@RequestBody Order order){
        return ResultGenerator.genSuccessResult(payService.wxpayCreatePay(order.getId()));
    }

    @RequestMapping(value = "/alipay/notify")
    public String alipayNotify(HttpServletRequest request){
        Map<String, String> params = AliPayApi.toMap(request);

        boolean verifyResult = false;
        try {
            verifyResult = AlipaySignature.rsaCheckV1(params, alipayPublicKey, charset, signType);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if(verifyResult){
            payService.alipayNotify(params);
            return "success";
        }else {
            return "非法请求,验证不通过,再恶意请求我就报警了";
        }
    }

    @RequestMapping(value = "/wxpay/notify")
    public String wxpayNotify(HttpServletRequest request){
        String xmlMsg = HttpKit.readData(request);
        Map<String, String> params = PaymentKit.xmlToMap(xmlMsg);

        boolean verifyResult = PaymentKit.verifyNotify(params, WxPayApiConfigKit.getWxPayApiConfig().getPaternerKey());
        if(verifyResult){
            payService.wxpayNotify(params);
            //向微信发送通知
            Map<String, String> xml = new HashMap<String, String>();
            xml.put("return_code", "SUCCESS");
            xml.put("return_msg", "OK");
            return PaymentKit.toXml(xml);
        }
        return "非法请求,验证不通过,再恶意请求我就报警了";
    }

    @RequestMapping(value = "/alipay/refund", method = RequestMethod.POST)
    public Result alipayRefund(@RequestBody Order order){
        payService.alipayRefund(order.getId());
        return ResultGenerator.genSuccessResult("退款成功");
    }

    @RequestMapping(value = "/wxpay/refund", method = RequestMethod.POST)
    public Result wxpayRefund(@RequestBody Order order){
        payService.wxpayRefund(order.getId());
        return ResultGenerator.genSuccessResult("退款成功");
    }
}
