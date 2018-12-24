package com.cn.web.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Configuration
@FeignClient(name = "userBaseProxy", url = "http://localhost:8081")
public interface UserBaseProxy {
    @RequestMapping("/userbaseinfo/findall/{page}/{size}")
    public List findAll(@PathVariable("page") int page, @PathVariable("size") int size);
}
