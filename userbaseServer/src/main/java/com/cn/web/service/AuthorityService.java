package com.cn.web.service;

import com.cn.jpa.dao.AuthorityDao;
import com.cn.jpa.entity.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService {
    @Autowired
    public AuthorityDao authorityDao;

    public List<Authority> findAll() {
        return authorityDao.findAll();
    }

    public Authority save(Authority authority) {
        return authorityDao.save(authority);
    }
}
