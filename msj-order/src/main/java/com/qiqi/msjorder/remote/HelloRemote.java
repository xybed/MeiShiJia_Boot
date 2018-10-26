package com.qiqi.msjorder.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "msj-api", fallback = HelloRemoteHystrix.class)
public interface HelloRemote {

    @RequestMapping("/hello")
    String hello();
}
