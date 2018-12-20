package com.cn.web;

import com.cn.jpa.entity.Authority;
import com.cn.jpa.entity.UserBase;
import com.cn.web.service.AuthorityService;
import com.cn.web.service.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/userbaseinfo")
public class UserBaseInfo {
    @Autowired
    public UserBaseService userBaseService;

    @Autowired
    public AuthorityService authorityService;

    @RequestMapping("/findall")
    public List<UserBase> findAll() {
        return userBaseService.findAll();
    }

    @RequestMapping("/findall/{page}/{size}")
    public Page<UserBase> findAll(@PathVariable(name = "page") int page, @PathVariable(name = "size") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return userBaseService.findAll(pageRequest);
    }

    @RequestMapping("/init/{num}")
    public String init(@PathVariable(name = "num") int num) {
        List<Authority> authorityList = authorityService.findAll();
        for (int i = 0; i < num; ++i) {
            String uuid = UUID.randomUUID().toString().substring(0, 7);
            UserBase userBase = new UserBase();
            userBase.username = uuid;
            userBase.password = uuid;
            userBase.authorityList = authorityList;
            userBaseService.save(userBase);
        }
        return "Test is finished!";
    }

    @RequestMapping("/count")
    public long count() {
        return userBaseService.count();
    }
}
