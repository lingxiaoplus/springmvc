package com.lingxiao.oa.service;

import com.lingxiao.oa.entity.Department;

import java.util.List;

public interface DepartmentService {
    void addDepartment(Department department);
    void remove(String sn);
    void edit(Department department);
    Department find(String sn);
    List<Department> findAll();
}
