package com.ruasib.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CookieDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        System.out.println("123");

        // 获取 输出流
        PrintWriter out = resp.getWriter();


        // 获取cookie
        Cookie[] cookies = req.getCookies();

        // 判断是否有cookie
        if (cookies != null){
            out.write("上一次访问时间是：");
            // 遍历查找cookie
            for (Cookie cookie :cookies
                    ) {

                System.out.println(cookie.getName());
                if(cookie.getName().equals("name")){

                    String value = URLDecoder.decode(cookie.getValue(),"utf-8");
                    out.write(value);
                    System.out.println(value);
                }


            }
        }else{
            out.write("第一次访问");
        }
        // 新建一个cookie
        Cookie cookie = new Cookie("name", URLEncoder.encode("阿达","utf-8"));

        cookie.setMaxAge(24*60*60);
        // 给客户端响应cookie
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
