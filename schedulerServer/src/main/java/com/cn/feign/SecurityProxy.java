package com.cn.feign;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Configuration
@FeignClient(name = "securityProxy", url = "http://localhost:8900/oauth")
public interface SecurityProxy {
    @RequestMapping(value = "/token", method = RequestMethod.POST,
            params = {"username=ADMIN",
                    "password=ADMIN",
                    "grant_type=password",
                    "client_id=abcd",
                    "client_secret=abcd"})
//    @Headers("Authorization:Basic YWJjZDphYmNk")
    public Object getToken();
}
