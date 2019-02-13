package com.cn.web;

import com.cn.feign.SecurityFeignService;
import com.cn.restTemplate.SecurityRestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GetTokenInfo {
    @Autowired
    protected SecurityFeignService securityFeignService;

    @Autowired
    protected SecurityRestTemplateService securityRestTemplateService;

    @RequestMapping("/restTemplate/getToken")
    public String getRestTemplateToken() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("username", "ADMIN");
        params.add("password", "ADMIN");
        params.add("grant_type", "password");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic YWJjZDphYmNk");
        return securityRestTemplateService.getToken(params, headers).getBody();
    }

    @RequestMapping("/feign/getToken")
    public String getFeignGetToken() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("username", "ADMIN");
        params.add("password", "ADMIN");
        params.add("grant_type", "password");
        String authString = "Basic YWJjZDphYmNk";
        return securityFeignService.getToken(authString, params);
    }
}
