package com.ruasib.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 请求转发
        ServletContext context = this.getServletContext();
        System.out.println("进入了ServletDemo04");
        // 获取转发的请求路径
        RequestDispatcher requestDispatcher = context.getRequestDispatcher("/gp");
        // 调用forward实现请求转发
        requestDispatcher.forward(req,resp);

//        第二种方式：实现请求转发
//        context.getRequestDispatcher("/gp").forward(req,resp);




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
