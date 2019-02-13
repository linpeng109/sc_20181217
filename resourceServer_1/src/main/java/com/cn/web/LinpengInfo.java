package com.cn.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/linpeng")
public class LinpengInfo {
    @RequestMapping("/getLinpeng")
    @RolesAllowed({"ROLE_ADMIN", "ROLE_USER"})
    public String linpeng() {
        return "Hello every one! ";
    }
}
