package com.qiqi.msjuser.test;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MQSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context = "hello" + new Date();
        System.out.println("Sender:" + context);
        rabbitTemplate.convertAndSend("hello", context);
    }

    public void sendMessage(){
        String context = "i am message 1";
        System.out.println("Sender:" + context);
        rabbitTemplate.convertAndSend("exchange", "topic.message", context);
    }

    public void sendMessages(){
        String context = "i am messages 2";
        System.out.println("Sender:" + context);
        rabbitTemplate.convertAndSend("exchange", "topic.messages", context);
    }
}
