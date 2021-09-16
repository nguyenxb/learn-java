package com.nguyenxb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class MyController {
    @RequestMapping("/some.do")
    public ModelAndView doSome(HttpSession httpSession,String name, Integer age) {
        System.out.println("执行了doSome方法"+name+":"+age);

        // 一个临时数据.
        httpSession.setAttribute("attr","MyController的一个临时数据.");

        ModelAndView modelAndView =  new ModelAndView();
        modelAndView.addObject("myname",name);
        modelAndView.addObject("myage",age);
        // 显示使用forward转发操作.即不加forward也是转发, 但是它的特点就是可以不被视图解析器限制
        modelAndView.setViewName("show");

        return modelAndView;
    }


}
