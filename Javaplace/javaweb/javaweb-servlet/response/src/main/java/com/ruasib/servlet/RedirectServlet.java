package com.ruasib.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//         // 实现重定向
//        resp.setHeader("Location","/res/img");
//        // 重定向状态码：302
//        resp.setStatus(302);// HttpServletResponse.SC_FOUND
           resp.sendRedirect("/res/img"); // 重定向
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
