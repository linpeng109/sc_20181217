package com.cn.web;

import com.cn.jpa.entity.Authority;
import com.cn.web.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authorityinfo")
public class AuthorityInfo {
    @Autowired
    public AuthorityService authorityService;

    @RequestMapping("/findall")
    public List<Authority> findAll() {
        return authorityService.findAll();
    }

    @RequestMapping("/init")
    public String init() {
        Authority admin = new Authority();
        admin.authorityString = "ROLE_ADMIN";
        authorityService.save(admin);

        Authority user = new Authority();
        user.authorityString = "ROLE_USER";
        authorityService.save(user);

        Authority guest = new Authority();
        guest.authorityString = "ROLE_GUEST";
        authorityService.save(guest);

        return "Test Success!";
    }
}
