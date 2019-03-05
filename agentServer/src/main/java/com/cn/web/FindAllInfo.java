package com.cn.web;

import com.cn.restTemplate.UserbaseRestTemplateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/userbase")
public class FindAllInfo {
    @Resource
    public UserbaseRestTemplateService userbaseRestTemplateService;

    @RequestMapping("/findall/{page}/{size}")
    public ResponseEntity<String> findall(@PathVariable("page") int page, @PathVariable("size") int size) {
        return userbaseRestTemplateService.findAll(page, size);
    }
}
