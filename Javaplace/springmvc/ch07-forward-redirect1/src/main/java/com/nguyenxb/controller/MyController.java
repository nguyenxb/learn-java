package com.nguyenxb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/controller")
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
    @RequestMapping("/doForward.do")
    public ModelAndView doForward(){
        ModelAndView modelAndView =  new ModelAndView();
        modelAndView.addObject("msg","doForward方法执行了");
        modelAndView.addObject("fun","进入了doForward方法");
        // 显示使用forward转发操作.即不加forward也是转发, 但是它的特点就是可以不被视图解析器限制
        modelAndView.setViewName("show");

        return modelAndView;
    }

    /*当控制器方法返回ModelAndView 实现重定向
    *   语法: modelAndView.setViewName("redirect:视图的完整路径");
    *   redirect 特点: 不和视图解析器一同工作, 就当项目中项目中没有视图解析器一样,
    *
    *   框架提供的重定向的功能
    *   1. 框架可以实现两次请求之间的数据传递,把第一个请求中的Model里面
    * 简单类型的数据,转为字符串, 附件到目标页面的后面, 做get参数传递,
    *   可以在目标页面中获取参数值使用.
    *   2.在目标页面中,可以使用${param.参数名}, 来获取参数的值.
    *   3. 重定向不能访问受保护的目录 /WEB-INF
    *
    * */
    @RequestMapping(value = "/doRedirect.do")
    public ModelAndView doRedirect(String name,Integer age){
        System.out.println("doRedirect:"+name+":"+age);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myname",name);
        modelAndView.addObject("myage",age);
        modelAndView.setViewName("redirect:/other.jsp");
        return modelAndView;
    }

}
