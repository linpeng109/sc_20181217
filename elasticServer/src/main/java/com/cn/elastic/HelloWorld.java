package com.cn.elastic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloinfo")
public class HelloWorld {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello ElasticSearch World!";
    }
}
