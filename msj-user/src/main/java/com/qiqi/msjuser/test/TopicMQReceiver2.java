package com.qiqi.msjuser.test;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.messages")
public class TopicMQReceiver2 {

    @RabbitHandler
    public void receiver(String message){
        System.out.println("Receiver2:"+message);
    }
}
