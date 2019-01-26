package com.cn.web;

import com.cn.feign.SecurityProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/security")
public class GetTokenInfo {
    @Autowired
    protected SecurityProxy securityProxy;

    protected RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/getToken")
    public String getToken() {
        Map<String, String> params = new HashMap<>();
        params.put("username", "ADMIN");
        params.put("password", "ADMIN");
        params.put("grant_type", "password");
        params.put("client_id", "abcd");
        params.put("client_secret", "abcd");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Basic YWJjZDphYmNk");
        HttpEntity entity = new HttpEntity(headers);

        headers.setContentType(MediaType.APPLICATION_JSON);
        restTemplate.
        ResponseEntity<String> result = restTemplate.getForEntity("http://abcd:abcd@localhost:8900/oauth/token", String.class, params);
        return result.toString();
    }
}
