package com.lingxiao.oa.controller;

import com.lingxiao.oa.entity.Department;
import com.lingxiao.oa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/list")
    public String list(Map<String,Object> map){
        List<Department> all = departmentService.findAll();
        System.out.println(" ==========="+ Arrays.toString(all.toArray()));
        map.put("list",all);
        return "department_list";
    }

    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        Department department = new Department();
        map.put("dept",department);
        System.out.println("添加部门界面");
        return "department_add";
    }

    @RequestMapping("/add")
    public String add(Department department){
        departmentService.addDepartment(department);
        System.out.println("添加部门");
        return "redirect:list";
    }

    @RequestMapping("/remove")
    public String remove(String sn){
        departmentService.remove(sn);
        return "redirect:list";
    }

    @RequestMapping(value = "/to_edit",params = "sn")
    public String toEdit(String sn,Map<String,Object> map){
        Department department = departmentService.find(sn);
        map.put("dept",department);
        return "department_edit";
    }

    @RequestMapping("/edit")
    public String edit(Department department){
        departmentService.edit(department);
        return "redirect:list";
    }
}
