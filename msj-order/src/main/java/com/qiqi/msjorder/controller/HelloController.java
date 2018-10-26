package com.qiqi.msjorder.controller;

import com.qiqi.msjorder.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Resource
    private HelloRemote helloRemote;

    /**
     * 获取所有服务
     */
    @RequestMapping("/services")
    public Object services() {
        return discoveryClient.getInstances("msj-api");
    }

    /**
     * 从所有服务中选择一个服务（轮询）
     */
    @RequestMapping("/discover")
    public Object discover() {
        return loadBalancerClient.choose("msj-api").getUri().toString();
    }

    @RequestMapping("/call")
    public String call(){
        String result = new RestTemplate().getForObject(loadBalancerClient.choose("msj-api").getUri().toString()+"/hello", String.class);
        return result;
    }

    @RequestMapping("/feign")
    public String feign(){
        return helloRemote.hello();
    }
}
