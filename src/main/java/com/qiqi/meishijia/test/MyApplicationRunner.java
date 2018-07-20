package com.qiqi.meishijia.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class MyApplicationRunner implements ApplicationRunner {
    @Value("${alipay.appid}")
    private String appid;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("初始化成功。。。。。。。。。。啦啦啦");
        System.out.println(appid);
    }
}
