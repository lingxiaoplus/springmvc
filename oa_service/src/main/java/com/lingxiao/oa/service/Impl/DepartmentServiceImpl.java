package com.lingxiao.oa.service.Impl;

import com.lingxiao.oa.dao.DepartmentDao;
import com.lingxiao.oa.entity.Department;
import com.lingxiao.oa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;
    public void addDepartment(Department department) {
        departmentDao.insert(department);
    }

    public void remove(String sn) {
        departmentDao.delete(sn);
    }

    public void edit(Department department) {
        departmentDao.update(department);
    }

    public Department find(String sn) {
        return departmentDao.findBySn(sn);
    }

    public List<Department> findAll() {
        return departmentDao.findAll();
    }
}
