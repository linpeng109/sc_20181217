package com.cn.web;

import com.cn.jpa.entity.Authority;
import com.cn.web.service.AuthorityService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/authorityinfo")
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class AuthorityInfo {
    @Autowired
    public AuthorityService authorityService;

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有权限", notes = "查询所有权限")
    public List<Authority> findAll() {
        return authorityService.findAll();
    }

    @RequestMapping("/init")
    @ApiIgnore
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
