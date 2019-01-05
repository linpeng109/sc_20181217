package com.cn.web;

import com.cn.amqp.Sender;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class HelloInfo {
    @Autowired
    public Sender sender;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        String result = "Hello world,The AmqpServer is running!";
        log.debug(result);
        return result;
    }

    @RequestMapping(value = "/sendInfo/{msg}", method = RequestMethod.GET)
    public String send(@PathVariable("msg") String msg) {
        return sender.sendMsg(msg);
    }

}
