package com.ruasib.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class propertiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  `/`代表当前web应用
        // 读取目录 target/servlet-02-1.0-SNAPSHOT//WEB-INF/classes/db.properties 的文件
//        InputStream inputStream = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");

        // 读取目录 target/servlet-02-1.0-SNAPSHOT//WEB-INF/classes/WEB-INF/classes/com/ruasib/servlet/aa.properties 的文件
        InputStream inputStream = this.getServletContext().getResourceAsStream(
                "/WEB-INF/classes/com/ruasib/servlet/aa.properties");
        Properties prop = new Properties();
        prop.load(inputStream);
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        resp.getWriter().print(username+":"+password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
