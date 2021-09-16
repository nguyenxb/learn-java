package com.nguyenxb.handle;

import com.nguyenxb.exception.AgeException;
import com.nguyenxb.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/*
*  @ControllerAdvice : 表示当前类是异常的处理类,
*       给controller增加功能的 ,
*   位置: 在类的上面
*
* */

@ControllerAdvice
public class GlobalExceptionHandler {
    // 定义处理异常的方法, 当异常发生后执行这个方法
    // 方法定义和Controller类中的方法的定义格式一样

    /*
    * 这个方法是处理NameException类型的异常
    * 参数:
    *   Exception: 表示Controller 抛出的异常对象.
    *
    *   ExceptionHandler : 表示此方法处理异常
    *          属性: value 异常的类型
    *           位置: 方法的上面
    * */
    @ExceptionHandler(value = NameException.class)
    public ModelAndView doNameException(Exception e){
        System.out.println("doNameException");
        /*
        * 发生异常:
        *    1. 记录异常,记录到日志文件中.
        *    2. 发生通知, 邮件,短信等等.
        *     3.给用户友好的提升
        * */
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tips","姓名只能是张三");
        modelAndView.setViewName("nameError");
        return modelAndView;
    }
    /*
    处理AgeException
    * */
 @ExceptionHandler(value = AgeException.class)
    public ModelAndView doAgeException(Exception e){
     System.out.println("doAgeException");
        /*
        * 发生异常:
        *    1. 记录异常,记录到日志文件中.
        *    2. 发生通知, 邮件,短信等等.
        *     3.给用户友好的提升
        * */
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tips","年龄不能大于80");
        modelAndView.setViewName("ageError");
        return modelAndView;
    }
    // 处理其他异常
@ExceptionHandler
    public ModelAndView doOtherException(Exception e){
    System.out.println("doOtherException");
        /*
        * 发生异常:
        *    1. 记录异常,记录到日志文件中.
        *    2. 发生通知, 邮件,短信等等.
        *     3.给用户友好的提升
        * */
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tips","请稍后重试");
        modelAndView.setViewName("defaultError");
        return modelAndView;
    }



}
