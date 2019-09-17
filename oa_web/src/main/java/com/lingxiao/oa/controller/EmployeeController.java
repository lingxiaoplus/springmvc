package com.lingxiao.oa.controller;

import com.lingxiao.oa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("employeeController")
@RequestMapping
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/list")
    public void list(){
        
    }
}
