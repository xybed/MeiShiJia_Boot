package com.qiqi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/hello")
    public String hello(@RequestParam String name){
        return "hello "+name+"，this is first message，serverPort:"+serverPort;
    }
}
