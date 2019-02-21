package com.cn.web.service;

import com.cn.jpa.dao.AuthorityDao;
import com.cn.jpa.entity.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableCaching
public class AuthorityService {
    @Autowired
    public AuthorityDao authorityDao;

    @Cacheable(value = "authorityCache")
    public List<Authority> findAll() {
        return authorityDao.findAll();
    }

    @CacheEvict(value = "authorityCache",allEntries = true)
    public Authority save(Authority authority) {
        return authorityDao.save(authority);
    }

    @CacheEvict(value = "authorityCache",allEntries = true)
    public void delete(Authority authority) {
        authorityDao.delete(authority);
    }
}
