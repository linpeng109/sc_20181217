package com.cn.elastic;

import com.cn.elastic.dao.EmployeeDAO;
import com.cn.elastic.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeInfo {
    @Autowired
    public EmployeeDAO employeeDAO;

    @RequestMapping("/hello")
    public String hello() {
        return "success";
    }

    @RequestMapping("/add")
    public Employee add() {
        Employee employee = new Employee();
        employee.setId("1");
        employee.setFirstName("a");
        employee.setLastName("b");
        return employeeDAO.save(employee);
    }

    @RequestMapping("/query/{id}")
    public Employee query(@PathVariable(value = "id") String id) {
        return employeeDAO.queryById(id);
    }
}
