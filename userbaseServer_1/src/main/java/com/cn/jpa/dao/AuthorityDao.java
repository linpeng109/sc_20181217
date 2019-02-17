package com.cn.jpa.dao;

import com.cn.jpa.entity.Authority;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface AuthorityDao extends Repository<Authority, String> {
    public List<Authority> findAll();

    public Authority save(Authority authority);
}
