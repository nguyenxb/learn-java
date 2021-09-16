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
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        UserService userService = new UserServiceImpl();
        User user = userService.login(userCode, userPassword);
        System.out.println(req.getContextPath()+"/jsp/frame.jsp");
        if(user != null){
            req.setAttribute(Constants.USER_SESSION,user);
            resp.sendRedirect(req.getContextPath()+"/jsp/frame.jsp");

        }else {
            req.setAttribute("error","用户名或者密码不正确");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
