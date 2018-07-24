package com.qiqi.meishijia.config;

import com.jpay.alipay.AliPayApiConfig;
import com.jpay.alipay.AliPayApiConfigKit;
import com.jpay.weixin.api.WxPayApiConfig;
import com.jpay.weixin.api.WxPayApiConfigKit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class PayInitRunner implements ApplicationRunner {

    @Value("${alipay.serviceUrl}")
    private String serviceUrl;
    @Value("${alipay.appId}")
    private String alipayAppId;
    @Value("${alipay.privateKey}")
    private String privateKey;
    @Value("${alipay.alipayPublicKey}")
    private String alipayPublicKey;
    @Value("${alipay.charset}")
    private String charset;
    @Value("${alipay.signType}")
    private String signType;

    @Value("${wxpay.appId}")
    private String wxpayAppId;
    @Value("${wxpay.mchId}")
    private String mchId;
    @Value("${wxpay.partnerKey}")
    private String partnerKey;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        AliPayApiConfig aliPayApiConfig = AliPayApiConfig.New()
                .setAppId(alipayAppId)
                .setAlipayPublicKey(alipayPublicKey)
                .setCharset(charset)
                .setPrivateKey(privateKey)
                .setServiceUrl(serviceUrl)
                .setSignType(signType)
                .build();
        AliPayApiConfigKit.setThreadLocalAliPayApiConfig(aliPayApiConfig);

        WxPayApiConfig wxPayApiConfig = WxPayApiConfig.New()
                .setAppId(wxpayAppId)
                .setMchId(mchId)
                .setPaternerKey(partnerKey);
        WxPayApiConfigKit.putApiConfig(wxPayApiConfig);
    }
}
