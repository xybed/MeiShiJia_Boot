package com.qiqi.msjorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.qiqi")
@ServletComponentScan("com.qiqi")
@EnableFeignClients
public class MsjOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsjOrderApplication.class, args);
    }
}
