package com.cn.security;

import com.cn.jpa.dao.UserDetailsDao;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@CacheConfig(cacheNames = "UserDetailsServerCache")
@EnableCaching
public class UserDetailsServer implements UserDetailsService {
    @Resource
    public UserDetailsDao userDetailsDao;

    @Override
    @Cacheable
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDetailsDao.findByUsername(username);
    }
}
