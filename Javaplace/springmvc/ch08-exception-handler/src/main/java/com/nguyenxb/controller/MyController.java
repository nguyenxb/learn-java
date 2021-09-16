package com.nguyenxb.controller;

import com.nguyenxb.exception.AgeException;
import com.nguyenxb.exception.NameException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    /*
    * 控制器方法返回的是ModelAndView 实现转发forward
    *
    *   语法: modelAndView.setViewName("forward:视图完成路径");
    *
    *   forward特点, 不和视图解析器一同工作的. 就是即使项目中配置了视图解析器,
    *       视图解析器也不会处理这个路径.
    *
    * */
    @RequestMapping("/some.do")
    public ModelAndView doSome(String name, Integer age) throws NameException, AgeException {
        System.out.println("执行了doSome方法"+name+":"+age);
        if (!"张三".equals(name)){
            throw new NameException("姓名不正确");
        }
        if (age==null || age.intValue() > 80){
            throw new AgeException("年龄太大");
        }


        ModelAndView modelAndView =  new ModelAndView();
        modelAndView.addObject("myname",name);
        modelAndView.addObject("myage",age);
        // 显示使用forward转发操作.即不加forward也是转发, 但是它的特点就是可以不被视图解析器限制
        modelAndView.setViewName("show");

        return modelAndView;
    }


}
