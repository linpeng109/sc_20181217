package com.cn.kafka;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Log4j2
@Component
public class KafkaProductor {
    public String topic = "test";

    @Autowired
    public KafkaTemplate kafkaTemplate;

    public void send(String msg) {
        ListenableFuture<String> future = kafkaTemplate.send(topic, msg);
        future.addCallback(
                result -> log.debug(result),
                throwable -> log.debug(throwable));
    }
}
