package com.cn.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "SecurityServer", url = "http://abcd:abcd@localhost:8900/oauth")
public interface SecurityProxy {
    @RequestMapping(value = "/token", method = RequestMethod.POST,
            params = {"username=ADMIN", "password=ADMIN", "grant_type=password"},
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getToken();
}