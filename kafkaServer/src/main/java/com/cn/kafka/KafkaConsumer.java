package com.cn.kafka;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class KafkaConsumer {
    @KafkaListener(topics = {"test"})
    public void receive(String msg) {
        log.debug("receive:" + msg);
    }
}
