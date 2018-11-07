package com.qiqi.msjfootball;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.qiqi")
@ServletComponentScan("com.qiqi")
public class MsjFootballApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsjFootballApplication.class, args);
    }
}
