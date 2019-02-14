package com.cn.jpa.dao;

import com.cn.jpa.entity.UserBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserBaseDao extends PagingAndSortingRepository<UserBase, String> {

    public List<UserBase> findAll();

    public Page<UserBase> findAll(Pageable pageable);

    public UserBase save(UserBase userBase);

    public long count();

    public void delete(UserBase userBase);
}
