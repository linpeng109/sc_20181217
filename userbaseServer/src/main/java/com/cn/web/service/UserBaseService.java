package com.cn.web.service;

import com.cn.jpa.dao.UserBaseDao;
import com.cn.jpa.entity.UserBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBaseService {
    @Autowired
    public UserBaseDao userBaseDao;

    public List<UserBase> findAll() {
        return userBaseDao.findAll();
    }

    public Page<UserBase> findAll(Pageable pageable) {
        return userBaseDao.findAll(pageable);
    }

    public UserBase save(UserBase userBase) {
        return userBaseDao.save(userBase);
    }

    public long count() {
        return userBaseDao.count();
    }
}
