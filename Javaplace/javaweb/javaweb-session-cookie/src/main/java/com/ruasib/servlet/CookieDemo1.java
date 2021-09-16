package com.ruasib.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

// 保存用户上一次访问的时间
public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // 服务器，告诉你，你来的时间，把这个时间封装成一个信件，你下次带来，我就知道你来了

        // 解决中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        // 获取输出流
        PrintWriter out = resp.getWriter();

        //Cookie, 服务器从客户端获取到
        Cookie[] cookies = req.getCookies();// 这里返回数组，说明Cookie可能存在多个

        // 判断Cookie是否存在
        if (cookies!=null){
            // 如果存在，则取出数组中的Cookie
            out.write("你上一次访问的时间是：");
            for (Cookie cookie:cookies
                 ) {
                if(cookie.getName().equals("lastLoginTime")){
//                    获取Cookie的值
                    long lastLoginTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastLoginTime);
                    out.write(date.toString());
                }
            }

        }else {

            out.write("这是你第一次访问本站");
        }

//        服务端给客户端响应Cookie
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+"");
        // 设置 cookie最长的存活时间 ，即有效期为以 1 天
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
