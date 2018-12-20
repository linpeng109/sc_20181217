package com.cn.web;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class HelloInfo {
    @Value("${spring.application.name}")
    private String SPRING_APPLICATION_NAME;

    @Value("${server.port}")
    private String SERVER_PORT;

    @Value("${my.name}")
    private String MY_NAME;

    @RequestMapping("/")
    public String hello() {
        return "The "
                + SPRING_APPLICATION_NAME
                + " is run at " + SERVER_PORT
                + ". My name is " + MY_NAME;
    }
}
