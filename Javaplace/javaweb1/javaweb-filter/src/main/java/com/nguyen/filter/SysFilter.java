package com.nguyen.filter;

import com.nguyen.util.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 获取session
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Object o = request.getSession().getAttribute(Constant.USER_SESSION);
        if(o==null){
            response.sendRedirect("/error.jsp");
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
