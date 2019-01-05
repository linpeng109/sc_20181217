package com.cn.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public String sendMsg(String message) {
        amqpTemplate.convertAndSend("hello", message);
        return "success";
    }
}
