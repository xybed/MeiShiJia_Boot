package com.qiqi.msjproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.qiqi")
@ServletComponentScan("com.qiqi")
@EnableDiscoveryClient
public class MsjProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsjProductApplication.class, args);
    }
}
