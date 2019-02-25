package com.cn.web;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RefreshScope
@RequestMapping("/helloinfo")
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class HelloInfo {
    @Value("${spring.application.name}")
    private String SPRING_APPLICATION_NAME;

    @Value("${server.port}")
    private String SERVER_PORT;

    @Value("${my.name}")
    private String MY_NAME;

    @RequestMapping(value = "/getHello", method = RequestMethod.GET)
    @ApiOperation(value = "hello函数", notes = "测试配置服务器功能")
    public String hello() {
        return "The "
                + SPRING_APPLICATION_NAME
                + " is run at " + SERVER_PORT
                + ". My name is  " + MY_NAME;
    }
}