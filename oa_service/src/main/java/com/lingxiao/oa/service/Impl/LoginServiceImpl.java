package com.lingxiao.oa.service.Impl;

import com.lingxiao.oa.dao.EmployeeDao;
import com.lingxiao.oa.entity.Employee;
import com.lingxiao.oa.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    //@Qualifier("employeeDao")
    @Autowired
    private EmployeeDao employeeDao;
    public Employee login(String sn, String password) {
        Employee employee = employeeDao.findBySn(sn);
        if(employee != null && employee.getPassword().equals(password)){
            return  employee;
        }
        return null;
    }

    public void changePassword(Employee employee) {
        employeeDao.update(employee);
    }
}
