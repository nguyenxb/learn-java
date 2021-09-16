package com.nguyenxb.service.user;

import com.nguyenxb.dao.BaseDao;
import com.nguyenxb.dao.user.UserDao;
import com.nguyenxb.dao.user.UserDaoImpl;
import com.nguyenxb.entity.User;

import java.sql.Connection;

public class UserServiceImpl implements UserService{
    // 业务层都会调用dao层，所以要引入Dao层
    private UserDao userDao;
    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }
    // 处理登录业务,用户不存在则返回空，用户存在但密码不正确返回一个没有任何值的user对象
    public User login(String userCode, String password) {
        Connection connection = BaseDao.getConnection();
        User loginUser = userDao.getLoginUser(connection, userCode);
        if(loginUser != null){
            if (loginUser.getUserPassword().equals(password)){
                return loginUser;
            }
        }
       return null;
    }
}
