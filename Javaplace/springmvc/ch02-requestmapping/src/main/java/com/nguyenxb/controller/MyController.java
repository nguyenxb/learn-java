package com.nguyenxb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller : 创建控制器(处理器)对象
 *  控制器: 叫做后端控制器(back controller), 自定义的类,处理请求的.
 *  位置: 写在类的上面, 表示创建此类的对象, 对象放在spring容器中.
 *
 * @RequestMapping
 *  属性 value : 表示所有请求地址的公共前缀, 相当于模块的名称
 *  位置在类的上面
 */
@RequestMapping("/test")
@Controller
public class MyController {
    /**
     * @RequestMapping : 请求映射
     *      属性: value 请求中的uri地址, 唯一值,以"/"开头
     *      位置: 1. 必须要在方法的上面,2. 在类定义的上面(可选的)
     *      作用: 把指定的请求,交给指定的方法处理,等同于url-pattern
     *
     * 返回值 ModelAndView: 表示本次请求的处理结果 (数据和视图)
     *      Model : 表示数据
     *      View : 表示视图
     *
     * */
//    @RequestMapping(value = {"test/some.do","test/first.do"})//类上方没有声明公共前缀
    @RequestMapping(value = {"/some.do","/first.do"})//类上方声明了公共前缀 /test
    public ModelAndView doSome(){
        System.out.println("doSome()方法执行了");
        ModelAndView modelAndView = new ModelAndView();
        // 添加数据
        modelAndView.addObject("msg","处理了Some.do请求");
        modelAndView.addObject("fun","执行了doSome方法");

        modelAndView.setViewName("show");
        // 返回结果
        return modelAndView;
    }
//    @RequestMapping(value = {"test/other.do","/test/second.do"})//类上方没有声明公共前缀
    @RequestMapping(value = {"/other.do","/second.do"})//类上方声明了公共前缀 /test
    public ModelAndView doOther(){

        ModelAndView modelAndView = new ModelAndView();
        // 添加数据
        modelAndView.addObject("msg","处理了Other.do请求");
        modelAndView.addObject("fun","执行了doOther方法");

        modelAndView.setViewName("other");
        // 返回结果
        return modelAndView;
    }
}
