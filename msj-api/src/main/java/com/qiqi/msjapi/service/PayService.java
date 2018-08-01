package com.qiqi.msjapi.service;

import java.util.Map;

public interface PayService {
    String alipayCreatePay(Integer orderId);

    String wxpayCreatePay(Integer orderId);

    void alipayNotify(Map<String, String> params);

    void wxpayNotify(Map<String, String> params);

    void alipayRefund(Integer orderId);

    void wxpayRefund(Integer orderId);
}
