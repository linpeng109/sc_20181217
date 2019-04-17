package com.cn.elastic.dao;

import com.cn.elastic.entity.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeDAO extends ElasticsearchRepository<Employee, String> {
    public Employee queryById(String id);
}
