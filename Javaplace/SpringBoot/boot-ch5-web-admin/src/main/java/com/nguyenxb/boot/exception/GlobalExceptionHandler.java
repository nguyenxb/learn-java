package com.nguyenxb.boot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 处理 整个web controller的异常.
@ControllerAdvice
public class GlobalExceptionHandler {
    // 处理异常,空指针异常,类未找到异常.
    @ExceptionHandler({NullPointerException.class,ClassCastException.class})
    public String myException(){
        return "err";// 返回的是视图地址,也可以使用ModelAndView
    }

}
