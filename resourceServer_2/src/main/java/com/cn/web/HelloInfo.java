package com.cn.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloInfo {
    @Value("${spring.application.name}")
    protected String SPRING_APPLICATION_NAME;

    @Value("${server.port}")
    protected String PORT;

    @RequestMapping("/getHello")
    public String hello() {
        String result = "The " + SPRING_APPLICATION_NAME + " is running at " + PORT;
        return result;
    }
}
