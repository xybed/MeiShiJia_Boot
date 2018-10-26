package com.qiqi.msjorder.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("msj-api")
public interface HelloRemote {

    @RequestMapping("/hello")
    String hello();
}
