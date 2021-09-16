package com.ruasib.session;

import com.ruasib.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.jsp.HttpJspPage;
import java.io.IOException;


public class SessionDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 往sessoion中存对象
//        HttpJspBase

       // 解决乱码问题
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");

        // 获取session对象
        HttpSession session = req.getSession();

        // 往session中存数据
        session.setAttribute("person",new Person());

        // 获取session的id
        String sessionId = session.getId();

        if (session.isNew()){
            resp.getWriter().write("session创建，Id="+sessionId);
        }else {
            resp.getWriter().write("session已经在服务器中存在，Id="+sessionId);
        }

        // Session 创建的时候做了什么事情：
//        Cookie cookie = new Cookie("JSESSIONID",sessionId);
//        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}
