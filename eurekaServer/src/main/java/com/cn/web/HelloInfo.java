package com.cn.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloInfo {

    @Value("${spring.application.name}")
    private String SPRING_APPLICATION_NAME;

    @Value("${server.port}")
    private String SERVER_PORT;

    @RequestMapping("/")
    public String hello() {
        return "The " + SPRING_APPLICATION_NAME + " is run at " + SERVER_PORT;
    }
}
