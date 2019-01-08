package com.cn.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@FeignClient(name = "amqpProxy", url = "http://localhost:8890")
public interface AmqpProxy {
    @RequestMapping("/sendInfo/{msg}")
    public String sendMsg(@PathVariable("msg") String msg);
}
