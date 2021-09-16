package com.nguyenxb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller : 创建控制器(处理器)对象
 *  控制器: 叫做后端控制器(back controller), 自定义的类,处理请求的.
 *  位置: 写在类的上面, 表示创建此类的对象, 对象放在spring容器中.
 */
@Controller
public class MyController {
    // 定义方法, 处理请求, 以前使用的是 get() ,post()方法


    /**
     *  springmvc框架, 使用控制器类中的方法, 处理请求.
     *  方法的特点:
     *   1.方法的形参,表示请求中的参数
     *   2.方法的返回值,表示本次请求的处理请求.
     */

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
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(){ // doGet()
        // 执行了myController的doSome方法.
        // 使用这个方法处理请求. 能处理亲切感的方法叫做控制器方法.
        // 调用service 对象, 处理请求,返回数据
        ModelAndView modelAndView = new ModelAndView();
        // 添加数据
        modelAndView.addObject("msg","处理了Some.do请求");
        modelAndView.addObject("fun","执行了doSome方法");

        // 指定显示数据的视图
//        modelAndView.setViewName("/WEB-INF/view/show.jsp");

        /*
        *  当配置了视图解析器, 使用文件名称作为视图名使用,叫视图逻辑名称
        * 使用了逻辑名称, 框架使用配置文件中视图解析器的前缀和后缀,拼接为完整的视图路径.
        * /WEB-INF/view/show.jsp
        * */
        modelAndView.setViewName("show");
        // 返回结果
        return modelAndView;
    }
    @RequestMapping(value = {"/other.do","/first.do","/test/second.do"})
    public ModelAndView doOther(){ // doGet()
        // 执行了myController的doOther方法.
        // 使用这个方法处理请求. 能处理亲切感的方法叫做控制器方法.
        // 调用service 对象, 处理请求,返回数据
        ModelAndView modelAndView = new ModelAndView();
        // 添加数据
        modelAndView.addObject("msg","处理了Other.do请求");
        modelAndView.addObject("fun","执行了doOther方法");

        // 指定显示数据的视图
//        modelAndView.setViewName("/WEB-INF/view/show.jsp");

        /*
        *  当配置了视图解析器, 使用文件名称作为视图名使用,叫视图逻辑名称
        * 使用了逻辑名称, 框架使用配置文件中视图解析器的前缀和后缀,拼接为完整的视图路径.
        * /WEB-INF/view/show.jsp
        * */
        modelAndView.setViewName("other");
        // 返回结果
        return modelAndView;
    }
    /**
     * 框架的操作流程:
     *  当框架调用完doSome()方法后,得到返回值ModelAdnView.
     *  框架会在后续的处理逻辑值,处理mv对象类名的数据和视图.
     *  对数据执行request.setAttribute("msg","处理了Some.do请求"),把数据放入到request作用域中
     *  对视图执行forward转发操作, 等同域request.getRequestDispatcher("/show.jsp").forward(req,resp);
     *
     * */
}
