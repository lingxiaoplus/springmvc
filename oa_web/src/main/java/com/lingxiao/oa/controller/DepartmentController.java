package com.lingxiao.oa.controller;

import com.lingxiao.oa.entity.Department;
import com.lingxiao.oa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
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
    };

}
