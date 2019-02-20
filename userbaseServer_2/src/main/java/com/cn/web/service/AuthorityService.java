package com.cn.web.service;

import com.cn.jpa.dao.AuthorityDao;
import com.cn.jpa.entity.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "AuthorityCache")
public class AuthorityService {
    @Autowired
    public AuthorityDao authorityDao;

    @Cacheable(value = "findAll")
    public List<Authority> findAll() {
        return authorityDao.findAll();
    }

    @CachePut(key = "#p0")
    public Authority save(Authority authority) {
        return authorityDao.save(authority);
    }
}
