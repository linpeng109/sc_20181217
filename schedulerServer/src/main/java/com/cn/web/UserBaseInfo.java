package com.cn.web;

import com.cn.web.feign.UserBaseProxy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/userbaseinfo")
public class UserBaseInfo {
    @Resource
    public UserBaseProxy userBaseProxy;

    @RequestMapping("/findall/{page}/{size}")
    public List findAll(@PathVariable("page") int page, @PathVariable("size") int size) {
        return userBaseProxy.findall(page, size);
    }
}
