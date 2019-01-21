package com.cn.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/linpeng")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class LinpengInfo {

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/getLinpeng")
    public String linpeng() {
        return "Hello every one! ";
    }

}
