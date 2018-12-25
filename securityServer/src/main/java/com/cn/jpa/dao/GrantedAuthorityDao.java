package com.cn.jpa.dao;

import com.cn.jpa.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrantedAuthorityDao extends JpaRepository<Role, String> {
    public Role save(Role role);

    public List<Role> findAll();
}
