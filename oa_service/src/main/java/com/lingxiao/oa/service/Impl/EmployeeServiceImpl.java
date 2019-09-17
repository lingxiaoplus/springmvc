package com.lingxiao.oa.service.Impl;

import com.lingxiao.oa.dao.EmployeeDao;
import com.lingxiao.oa.entity.Employee;
import com.lingxiao.oa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public void add(Employee employee) {
        employee.setPassword("000000");
        employeeDao.insert(employee);
    }

    public void edit(Employee employee) {
        employeeDao.update(employee);
    }

    public void remove(String sn) {
        employeeDao.delete(sn);
    }

    public Employee get(String sn) {
        return employeeDao.findBySn(sn);
    }

    public List<Employee> getAll() {
        return employeeDao.findAll();
    }
}
