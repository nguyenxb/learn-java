package com.nguyen.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    // 初始化：在服务器启动时调用此方法
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter 初始化");
    }

    // Chain：链，可以有很多个过滤器
    /*
    * 1,过滤器中的所以代码，在过滤特定请求的时候都会执行
    *  2,必须要让过滤器继续通行：  filterChain.doFilter(servletRequest,servletResponse);
    * */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html; charset=UTF-8");

        System.out.println("过滤前");
        // 让我们的请求继续通行，如果不写，程序就在这里就被拦截了
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("过滤后");

    }
    // 销毁：在服务器停止的时候调用此方法
    public void destroy() {
        System.out.println("CharacterEncodingFilter 销毁");
    }
}
