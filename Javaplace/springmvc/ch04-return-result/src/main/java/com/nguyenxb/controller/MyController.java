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

    /**
     * 控制方法返回String,表示逻辑名称,需要在项目中配置视图解析器
     */
    @RequestMapping(value = "/return-string-view1.do", method = RequestMethod.POST)//类上方声明了公共前缀 /test
    public String doReturnStringView1(HttpServletRequest request,String name , Integer age){
        System.out.println("doReturnStringView1()方法执行了");

        // 也可以在这里,处理数据
        request.setAttribute("myname",name);
        request.setAttribute("myage",age);


        // 返回结果,forward, 转发到了show.jsp
        return "show";
    }

 @RequestMapping(value = "/return-string-view2.do", method = RequestMethod.POST)//类上方声明了公共前缀 /test
    public String doReturnStringView2(String name , Integer age){
        System.out.println("doReturnStringView2()方法执行了");

        // 返回结果,forward, 转发到了show.jsp,
        // 不使用视图解析器,如果使用,它的实际地址就会这样
       //  : /WEB-INF/view/WEB-INF/view/show.jsp.jsp
        return "/WEB-INF/view/show.jsp";
    }
    // 控制器方法,返回的是void,响应ajax请求,使用HttpServletResponse输出数据.
@RequestMapping(value = "return-void-ajax1.do", method = RequestMethod.POST)//类上方声明了公共前缀 /test
    public void doReturnVoidAjax1(HttpServletResponse response,String name , Integer age) throws IOException {
        System.out.println("doReturnVoidAjax1()方法执行了");

        Student student = new Student();
        student.setName(name+"同学");
        student.setAge(age);

            // 把对象转成json
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(student);
        System.out.println("服务器将对象转成json:"+json);

        // 输出json, 响应ajax
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(json);
        writer.flush();
        writer.close();
    }

    /**
     * 控制器方法返回Student 并将对象转成 json
     * 编码格式: application/json;charset=utf-8
     *
     * 框架的处理模式:
     *  1. 框架根据控制器放啊的返回值类型,找到HttpMessageConverter接口的实现类.
     *      最后找到的是MappingJackson2HttpMessageConverter.
     *  2. 使用实现类MappingJackson2HttpMessageConverter.执行他的write()方法,
     *      把student 对象转成了json格式的数据.
     *  3. 框架使用@ResponseBody注解, 把 2中的json输出给浏览器.
     *
     * */
    @RequestMapping("/doStudentJson.do")
    @ResponseBody
    public Student doAjaxJson(String name, Integer age){
        System.out.println("控制器方法返回自定义对象, 转为json:"+name+"=="+age);
        Student student = new Student();
        student.setName(name+"同学");
        student.setAge(age);
        return student;
    }

    /*
       返回List集合
    * */
    @RequestMapping("/doAjaxJsonArray.do")
    @ResponseBody
    public List<Student> doAjaxJsonArray(String name, Integer age){
        System.out.println("控制器方法返回自定义对象, 转为json:"+name+"=="+age);
        Student student = new Student();
        student.setName("李四同学");
        student.setAge(age);
        Student student1 = new Student();
        student1.setName("张三同学");
        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        return students;
    }
 /*
       控制器方法返回 String 类型的数据,

       区分返回值是视图还是数据的方法就是 看方法上面是否有@ResponseBody注解.
       如果没有就是视图,如果有就是数据.

        默认的传输字符
       Content-Type: text/plain;charset=ISO-8859-1

       解决中文, 需要使用@RequestMapping 的produces属性.
       produces属性: 指定Content-Type.的值.

       框架处理String返回值
        1.框架使用的StringHttpMessageConverten
        2. StringHttpMessageConverter默认使用的是text/plain;charset=ISO-8859-1

    * */
    @RequestMapping(value = "/doStringData.do",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String doStringData(String name, Integer age){
        System.out.println("控制器方法返回String,是数据");

        return "Hello Springmvc注解式开发";
    }


}
