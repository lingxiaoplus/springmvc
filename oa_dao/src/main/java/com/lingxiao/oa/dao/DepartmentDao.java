package com.lingxiao.oa.dao;

import com.lingxiao.oa.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("departmentDao")
public interface DepartmentDao {
    void insert(Department department);
    void delete(String sn);
    void update(Department department);
    Department findBySn(String sn);
    List<Department> findAll();
}
