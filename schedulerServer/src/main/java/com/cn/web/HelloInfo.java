package com.cn.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloInfo {
    @Value("${spring.application.name}")
    private String APPLICATION_NAME;

    @Value("${server.port}")
    private String PORT;

    @Value("${my.name}")
    private String MY_NAME;

    @RequestMapping("/")
    public String hello() {
        return "The "
                + APPLICATION_NAME
                + " is run at "
                + PORT
                + ". My name is "
                + MY_NAME;
    }
}
