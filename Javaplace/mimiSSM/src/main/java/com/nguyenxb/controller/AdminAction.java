package com.nguyenxb.controller;

import com.nguyenxb.pojo.Admin;
import com.nguyenxb.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminAction {
    @Autowired
    AdminService adminService;
    /**
     * @param name 传入的用户名
     * @param pwd 传入的密码
     * @return 视图和数据(前端界面)
     */
    @RequestMapping("/login.action")
    public ModelAndView login(String name,String pwd){
        ModelAndView modelAndView = new ModelAndView();

        Admin admin = adminService.login(name, pwd);

        if (admin != null){
            modelAndView.addObject("admin",admin);
            modelAndView.setViewName("main");
        }else {
            modelAndView.addObject("errmsg","用户名或密码不正确.");
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }
}
