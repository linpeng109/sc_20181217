package com.cn.web;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class HelloInfo {
    @Value("${spring.application.name}")
    String SERVER_NAME;

    @Value("${server.port}")
    String PORT;

    @RequestMapping("/hello")
    public String hello() {
        String result = "The " + SERVER_NAME + " is running at " + PORT;
        return result;
    }
}
