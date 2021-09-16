package com.nguyenxb.servlet.user;

import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;
import com.nguyenxb.entity.User;
import com.nguyenxb.service.user.UserService;
import com.nguyenxb.service.user.UserServiceImpl;
import com.nguyenxb.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(0);
       String method = req.getParameter("method");
        System.out.println(method);
       // 如果 提交请求为savepwd
       if (method != null&&method.equals("savepwd")){
           this.updatePwd(req);
       }else if (method != null && method.equals("pwdmodify")){//提交请求为 验证旧密码请求
           this.padModify(req,resp);
       }


    }

    private void padModify(HttpServletRequest req, HttpServletResponse resp) {
        // 从 session中获取拿用户的id
        Object o = req.getSession().getAttribute(Constants.USER_SESSION);
        String oldpassword = req.getParameter("oldpassword");

        // 万能的Map : 结果集
        Map<String,String> resultMap = new HashMap<String, String>();
        System.out.println(1);

        if (o==null){// session失效了,session过期了
            System.out.println(2);
            resultMap.put("result","sessionerror");
        }else if (StringUtils.isNullOrEmpty(oldpassword)){// 输入密码为空
            resultMap.put("result","error");
            System.out.println(3);
        }else {
            System.out.println(4);
            String userPassword = ((User) o).getUserPassword();
            if (userPassword.equals(oldpassword)){
                System.out.println(5);
                resultMap.put("result","true");
            }else {
                System.out.println(6);
                resultMap.put("result","false");
            }
        }

        try {
            // 响应的数据类型
            resp.setContentType("application/json");
            // 获取输出流
            PrintWriter writer = resp.getWriter();
            // JSONArray 阿里巴巴的json工具类,功能: 传入一个对象,转换成json格式
            /*
            resultMap = ["result","sessionerror","result","error"]
            Json格式: {key:value}
            * */
            String jsonString = JSONArray.toJSONString(resultMap);
            System.out.println(jsonString);
            writer.write(JSONArray.toJSONString(resultMap));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void updatePwd(HttpServletRequest req) {
        // 从获取user_session ,从session中拿id
        Object o = req.getSession().getAttribute(Constants.USER_SESSION);
        String newPassword = req.getParameter("newpassword");

        // 当user_session存在,且输入的新密码不为空
        if (o!=null && !StringUtils.isNullOrEmpty(newPassword)){
            UserService userService = new UserServiceImpl();
            boolean flag = userService.updatePwd(((User) o).getId(), newPassword);
            if (flag){
                req.setAttribute("message","修改密码成功,请退出,使用新密码登录");
                // 密码修改成功,移除当前Session
                req.getSession().removeAttribute(Constants.USER_SESSION);
            }else {
                // 密码修改失败
                req.setAttribute("message","密码修改失败");
            }
        }else {
            req.setAttribute("message","新密码有问题");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
