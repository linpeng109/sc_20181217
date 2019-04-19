package com.cn.web;

import com.cn.kafka.KafkaProductor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messageinfo")
public class MessageInfo {
    @Autowired
    public KafkaProductor kafkaProductor;

    @RequestMapping("/send/{msg}")
    public String send(@PathVariable("msg") String msg) {
        kafkaProductor.send(msg);
        return "success";
    }
}
