package com.cn.jpa.dao;

import com.cn.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDetailsDao extends JpaRepository<User, String> {
    public User findByUsername(final String username);

    public List<User> findAll();

    public User save(User user);

    public void delete(User user);
}
