package com.qiqi.msjapi.test;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.message")
public class TopicMQReceiver1 {

    @RabbitHandler
    public void receiver(String message){
        System.out.println("Receiver1:"+message);
    }
}
