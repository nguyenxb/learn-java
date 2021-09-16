package com.nguyenxb.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nguyenxb.vo.Student;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    @RequestMapping(value = "/some.do", method = RequestMethod.POST)//类上方声明了公共前缀 /test
    public ModelAndView doReturnStringView1(String name , Integer age){
        System.out.println("doReturnStringView1()方法执行了");
        ModelAndView modelAndView = new ModelAndView();
        // 也可以在这里,处理数据
        modelAndView.addObject("myname",name);
        modelAndView.addObject("myage",age);

        modelAndView.setViewName("show");
        // 返回结果,forward, 转发到了show.jsp
        return modelAndView;
    }

}
