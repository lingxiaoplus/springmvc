package com.lingxiao.oa.controller;

import com.lingxiao.oa.entity.Employee;
import com.lingxiao.oa.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller("loginController")
//@RequestMapping("/loginController")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "/login")
    public String login(HttpSession session, @RequestParam String sn, @RequestParam String password){
        Employee employee = loginService.login(sn, password);
        if (employee != null){
            session.setAttribute("employee",employee);
            return "redirect:self";
        }
        return "redirect:to_login";
    }
    @RequestMapping("/quit")
    public String quit(HttpSession session){
        session.removeAttribute("employee");
        return "redirect:to_login";
    }

    @RequestMapping("/self")
    public String selfInfo(){
        return "self";
    }

    @RequestMapping("/to_changePassword")
    public String toChangePassword(){
        return "changePassword";
    }

    @RequestMapping("/changePassword")
    public String changePassword(HttpSession session,@RequestParam String old, @RequestParam String password, @RequestParam String rePassword){
        Employee user = (Employee) session.getAttribute("employee");
        if (user.getPassword() != old){
            return "redirect:changePassword";
        }else {
            if (password.equals(rePassword)){
                user.setPassword(password);
                loginService.changePassword(user);
            }else {
                return "redirect:self";
            }
        }
        return "redirect:changePassword";
    }
}
