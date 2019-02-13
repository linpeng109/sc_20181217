package com.cn.restTemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class SecurityRestTemplateService {

    public ResponseEntity<String> getToken(MultiValueMap<String, String> params, HttpHeaders headers) {
        String url = "http://localhost:8900/oauth/token";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity entity = new HttpEntity(params, headers);
        ResponseEntity<String> result = restTemplate.postForEntity(url, entity, String.class);
        return result;
    }
}
