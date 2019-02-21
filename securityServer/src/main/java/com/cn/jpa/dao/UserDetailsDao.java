package com.cn.jpa.dao;

import com.cn.jpa.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@EnableCaching
public interface UserDetailsDao extends JpaRepository<User, String> {
    @Cacheable(value = "UserDetailsDaoCache")
    public User findByUsername(final String username);

    @Cacheable(value = "UserDetailsDaoCache")
    public List<User> findAll();

    @CacheEvict(value = "UserDetailsDaoCache")
    public User save(User user);

    @CacheEvict(value = "UserDetailsDaoCache")
    public void delete(User user);
}
