package com.cn.elastic;

import com.cn.elastic.dao.EmployeeDAO;
import com.cn.elastic.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employeeinfo")
public class EmployeeInfo {
    @Autowired
    public EmployeeDAO employeeDAO;

    @RequestMapping("/hello")
    public String hello() {
        return "success";
    }

    @RequestMapping("/add/{num}")
    public List<Employee> add(@PathVariable("num") int num) {
        List<Employee> employeeList = new ArrayList();
        for (int i = 0; i < num; ++i) {
            Employee employee = new Employee();
            employee.setId((String.valueOf(i + 100)));
            employee.setFirstName("a");
            employee.setLastName("b");
            employeeList.add(employeeDAO.save(employee));
        }
        return employeeList;
    }

    @RequestMapping("/query/{id}")
    public Employee query(@PathVariable(value = "id") String id) {
        return employeeDAO.queryById(id);
    }

    @RequestMapping("/queryall")
    public Iterable<Employee> queryAll() {
        return employeeDAO.findAll();
    }
}
