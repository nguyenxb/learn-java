package com.nguyenxb.servlet.user;

import com.nguyenxb.entity.User;
import com.nguyenxb.service.user.UserService;
import com.nguyenxb.service.user.UserServiceImpl;
import com.nguyenxb.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取 用户登录的账号和密码
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        UserService userService = new UserServiceImpl();
        // 如果数据库中无此用户或者密码不正确,则返回空
        User user = userService.login(userCode, userPassword);
        // user不为空时,则成功登录,将用户信息存到session中并跳转到主页
        if(user != null){
            req.getSession().setAttribute(Constants.USER_SESSION,user);
            resp.sendRedirect(req.getContextPath()+"/jsp/frame.jsp");
        }else {
            // 登录失败,则通过返回请求错误信息
            req.setAttribute("error","用户名或者密码不正确");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
