package com.cn.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/world")
public class WorldInfo {
    @RequestMapping("/getworld")
    public String world() {
        return "Hi I am a World!";
    }
}
