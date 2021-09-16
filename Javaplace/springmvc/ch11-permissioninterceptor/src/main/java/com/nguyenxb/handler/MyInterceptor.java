package com.nguyenxb.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle()方法执行了");
        String username = "";
        // 获取登录账号的信息
        Object attribute = request.getSession().getAttribute("username");
        if (attribute != null){
            username = (String) attribute;
        }
        // 判断账号是否正确
        if ("张三".equals(username)){
            return true;
        }
        request.getRequestDispatcher("/tips.jsp").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle()方法执行了");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion()方法执行了");
    }
}
