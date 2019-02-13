package com.cn.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "SecurityServer", url = "http://localhost:8900/oauth")
public interface SecurityFeignService {
    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public String getToken(@RequestHeader("Authorization") String authHeader, @RequestParam MultiValueMap<String, String> params);
}