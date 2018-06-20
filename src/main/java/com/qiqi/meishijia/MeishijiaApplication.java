package com.qiqi.meishijia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ServletComponentScan //spring能够扫描到我们自己编写的servlet和filter
//@EnableScheduling //开启对计划任务的支持
public class MeishijiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeishijiaApplication.class, args);
    }

}
