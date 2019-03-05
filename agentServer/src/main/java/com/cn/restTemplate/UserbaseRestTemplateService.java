package com.cn.restTemplate;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserbaseRestTemplateService {
    public ResponseEntity<String> findAll(int page, int size) {
        String url = "http://localhost:8080/userbaseserver/userbaseinfo/findall/" + "/";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
        return result;
    }
}