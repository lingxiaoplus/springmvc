package com.lingxiao.oa.controller;

import com.lingxiao.oa.entity.Department;
import com.lingxiao.oa.entity.Employee;
import com.lingxiao.oa.global.Contant;
import com.lingxiao.oa.service.DepartmentService;
import com.lingxiao.oa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        List<Employee> all = employeeService.getAll();
        System.out.println("员工列表"+ Arrays.toString(all.toArray()));
        map.put("list",employeeService.getAll());
        return "employee_list";
    }

    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        Employee employee = new Employee();
        map.put("employee",employee);
        map.put("dlist",departmentService.findAll());
        map.put("plist", Contant.getPosts());
        return "employee_add";
    }

    @RequestMapping("/add")
    public String add(Employee employee){
        employeeService.add(employee);
        return "redirect:list";
    }

    @RequestMapping(value = "/delete",params = "sn")
    public String delete(@RequestParam String sn){
        employeeService.remove(sn);
        return "redirect:list";
    }

    @RequestMapping(value = "/to_edit",params = "sn")
    public String toEdit(Map<String,Object> map,@RequestParam String sn){
        map.put("empt",employeeService.get(sn));
        map.put("dlist",departmentService.findAll());
        map.put("plist", Contant.getPosts());
        return "employee_edit";
    }

    @RequestMapping("/edit")
    public String edit(Employee employee){
        employeeService.edit(employee);
        return "redirect:list";
    }
}
