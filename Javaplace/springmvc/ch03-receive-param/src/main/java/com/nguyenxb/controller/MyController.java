package com.nguyenxb.controller;

import com.nguyenxb.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Controller : 创建控制器(处理器)对象
 *  控制器: 叫做后端控制器(back controller), 自定义的类,处理请求的.
 *  位置: 写在类的上面, 表示创建此类的对象, 对象放在spring容器中.
 *
 * @RequestMapping
 *  属性 value : 表示所有请求地址的公共前缀, 相当于模块的名称
 *  位置在类的上面
 */
@Controller
public class MyController {
    /**
     * 逐个接收请求参数,
     *  要求: 请求中的参数名和控制器方法的形参名要一样,按名称对象接收请求参数.
     *
     *  参数接收:
     *  1. 框架使用request对象,接收参数.
     *      String name = request.getParameter("name");
     *      String age = request.getParameter("age");
     *  2. 在中央调度器的内部调用doProperParam方法时,按照名称对象传递参数
     *      doPropertyParam(name,Integer.valueOf(age))
     *      框架可以实现请求参数String到int,long,float,double等类型的转换
     */
    @RequestMapping(value = "/receive-param1.do", method = RequestMethod.POST)//类上方声明了公共前缀 /test
    public ModelAndView doPropertyParam1(String name , Integer age){
        System.out.println("doPropertyParam1()方法执行了");
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(name+":"+age);
        // 添加数据
        modelAndView.addObject("myname",name);
        modelAndView.addObject("myage",age);

        modelAndView.setViewName("show");
        // 返回结果
        return modelAndView;
    }
     /* @RequestParam : 解决名称不一样的问题
     *      属性: value 请求中的参数名称
     *           required : boolean类型的, 默认是true
     *              true : 请求中必须有此参数,没有的话就会报错.
     *             false : 请求中可以没有此参数
     *      位置: 在形参定义的前面
     * */
    @RequestMapping(value = "/receive-param2.do", method = RequestMethod.POST)//类上方声明了公共前缀 /test
    public ModelAndView doPropertyParam2(@RequestParam(value = "AAname",required = true) String name ,
                                        @RequestParam(value = "AAage",required = false) Integer age){
        System.out.println("doPropertyParam2()方法执行了");
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(name+":"+age);
        // 添加数据
        modelAndView.addObject("myname",name);
        modelAndView.addObject("myage",age);

        modelAndView.setViewName("show");
        // 返回结果
        return modelAndView;
    }
    /*
    * 使用对象接收请求中的参数,
    *   要求: 参数名和java的对象属性名一样
    *           java类需要有一个无参数构造方法,属性有set方法.
    *   框架如何处理对象参数?
    *      1. 调用Student对象的参数构造方法,创建对象
    *       2.调用对象set方法,同名的参数,调用对应的set方法.
    *           参数是name,调用setName(参数值).
    *     注意: 如果使用对象接收参数, 无法使用别名来接收参数,
    *           对象的属性名和参数名必须一样.
    * */
    @RequestMapping(value = "/receive-param3.do", method = RequestMethod.POST)//类上方声明了公共前缀 /test
    public ModelAndView doPropertyParam3(Student student){
        System.out.println("doPropertyParam3()方法执行了");
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(student);
        // 添加数据
        modelAndView.addObject("myname",student.getName());
        modelAndView.addObject("myage",student.getAge());

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
