package com.nguyenxb.filter;

import com.nguyenxb.util.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 获取用户的user_session
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        Object attribute = request.getSession().getAttribute(Constants.USER_SESSION);
        // 如果用户已经登录,则可以继续访问,否则,进入error页面
        if (attribute == null){
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }


    }

    public void destroy() {

    }
}
