package com.ruasib.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        this.getInitParameter(String name); 初始化参数
//        this.getServletConfig()       Servlet配置
//        this.getServletContext();     Servlet上下文对象

        ServletContext servletContext = this.getServletContext();
        String username = "ruasib"; // 数据
        // 将一个数据保存在ServletContext中，键为username,值为username（变量）
        servletContext.setAttribute("username",username);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print("写入数据"+username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
