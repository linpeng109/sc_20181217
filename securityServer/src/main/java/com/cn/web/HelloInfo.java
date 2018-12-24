package com.cn.web;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class HelloInfo {
    @RequestMapping("/")
    public String hello() {
        return "Hello world ! Security Server";
    }
}
