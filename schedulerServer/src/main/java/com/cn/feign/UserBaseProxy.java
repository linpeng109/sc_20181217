package com.cn.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@FeignClient(name = "userBaseProxy", url = "http://localhost:8081")
public interface UserBaseProxy {
    @RequestMapping("/userbaseinfo/findall/{page}/{size}")
    public String findAll(@PathVariable("page") int page, @PathVariable("size") int size);
}
