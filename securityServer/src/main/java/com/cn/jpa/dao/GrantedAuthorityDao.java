package com.cn.jpa.dao;

import com.cn.jpa.entity.Role;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@EnableCaching
public interface GrantedAuthorityDao extends JpaRepository<Role, String> {
    @CacheEvict(value = "GrantedAuthorityDaoCache")
    public Role save(Role role);

    @CacheEvict(value = "GrantedAuthorityDaoCache")
    public void delete(Role role);

    @Cacheable(value = "GrantedAuthorityDaoCache")
    public Role findByAuthority(String authorityString);

    @Cacheable(value = "GrantedAuthorityDaoCache")
    public List<Role> findAll();
}
