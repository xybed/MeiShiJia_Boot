package com.qiqi.msjapi.test;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class MQReceiver {

    @RabbitHandler
    public void process(String hello){
        System.out.println("Receiver:"+hello);
    }

}
