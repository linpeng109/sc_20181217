package com.cn.web;

import com.cn.feign.UserBaseProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userbaseinfo")
public class UserBaseInfo {
    @Autowired
    public UserBaseProxy userBaseProxy;

    @RequestMapping("/findall/{page}/{size}")
    public String findAll(@PathVariable("page") int page, @PathVariable("size") int size) {
        return userBaseProxy.findAll(page, size);
    }
}
