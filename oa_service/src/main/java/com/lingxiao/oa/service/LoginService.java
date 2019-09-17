package com.lingxiao.oa.service;

import com.lingxiao.oa.entity.Employee;

public interface LoginService {
    Employee login(String sn, String password);
    void changePassword(Employee employee);
}
