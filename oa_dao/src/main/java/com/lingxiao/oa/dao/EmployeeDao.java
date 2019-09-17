package com.lingxiao.oa.dao;

import com.lingxiao.oa.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("employeeDao")
public interface EmployeeDao {
    void insert(Employee employee);
    void delete(String sn);
    void update(Employee employee);
    Employee findBySn(String sn);
    List<Employee> findAll();
}
