package com.cn.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/world")
public class WorldInfo {
    @RequestMapping("/getWorld")
    public String world() {
        return "The token is OK !";
    }
}