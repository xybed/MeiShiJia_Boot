package com.qiqi.msjorder.remote;

import org.springframework.stereotype.Component;

@Component
public class HelloRemoteHystrix implements HelloRemote{

    @Override
    public String hello() {
        return "断路器起作用";
    }
}
