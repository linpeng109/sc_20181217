package com.cn.web.service;

import com.cn.jpa.dao.UserBaseDao;
import com.cn.jpa.entity.UserBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableCaching
public class UserBaseService {
    @Autowired
    public UserBaseDao userBaseDao;

    @Cacheable(value = "userBaseCache")
    public List<UserBase> findAll() {
        return userBaseDao.findAll();
    }

    @Cacheable(value = "userBaseCache")
    public Page<UserBase> findAll(Pageable pageable) {
        return userBaseDao.findAll(pageable);
    }

    @CacheEvict(value = "userBaseCache", allEntries = true)
    public UserBase save(UserBase userBase) {
        return userBaseDao.save(userBase);
    }

    @CacheEvict(value = "userBaseCache", allEntries = true)
    public void delete(UserBase userBase) {
        userBaseDao.delete(userBase);
    }

    @Cacheable(value = "userBaseCache")
    public long count() {
        return userBaseDao.count();
    }
}
