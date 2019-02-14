package com.cn.web.service;

import com.cn.jpa.dao.UserBaseDao;
import com.cn.jpa.entity.UserBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "UserBaseCache")
public class UserBaseService {
    @Autowired
    public UserBaseDao userBaseDao;

    @Cacheable(value = "findAll")
    public List<UserBase> findAll() {
        return userBaseDao.findAll();
    }

    @Cacheable(value = "findAllByPage")
    public Page<UserBase> findAll(Pageable pageable) {
        return userBaseDao.findAll(pageable);
    }

    @CachePut(key = "#p0")
    public UserBase save(UserBase userBase) {
        return userBaseDao.save(userBase);
    }

    @Cacheable(value = "count")
    public long count() {
        return userBaseDao.count();
    }
}
