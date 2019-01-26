package com.cn.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/hello")
public class HelloInfo {
    @Value("${spring.application.name}")
    protected String SPRING_APPLICATION_NAME;

    @Value("${server.port}")
    protected String SERVER_PORT;

    @RequestMapping("/getHello")
    public String hello() {
        Date current = new Date();
        String result = "The " + SPRING_APPLICATION_NAME + " is running at " + SERVER_PORT;
        return result;
    }
}
