package com.cn.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@FeignClient(name = "redisProxy", url = "http://localhost:8891")
public interface RedisProxy {
    @RequestMapping("/redisInfo/set/{name}/{msg}/{seconds}")
    public String send(@PathVariable("name") String name, @PathVariable("msg") String msg, @PathVariable("seconds") long seconds);
}
