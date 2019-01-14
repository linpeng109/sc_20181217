package com.cn.web;

import com.cn.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redisInfo")
public class RedisInfo {
    @Autowired
    public RedisService redisService;

    @RequestMapping("/set/{key}/{value}/{seconds}")
    public String set(@PathVariable("key") String key, @PathVariable("value") Object value, @PathVariable("seconds") long seconds) {
        redisService.setValue(key, value, seconds);
        return "success";
    }

    @RequestMapping("/get/{key}")
    public Object get(@PathVariable("key") String key) {
        return redisService.getValue(key);
    }
}
