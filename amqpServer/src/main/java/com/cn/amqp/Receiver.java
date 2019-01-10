package com.cn.amqp;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RabbitListener(queues = "hello")
public class Receiver {
    @RabbitHandler
    public void reciveMsg(String message) {
        log.debug("receive message: " + message);
    }
}
