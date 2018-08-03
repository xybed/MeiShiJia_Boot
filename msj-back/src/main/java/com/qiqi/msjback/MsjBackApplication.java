package com.qiqi.msjback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.qiqi")
@ServletComponentScan("com.qiqi")
public class MsjBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsjBackApplication.class, args);
    }
}
