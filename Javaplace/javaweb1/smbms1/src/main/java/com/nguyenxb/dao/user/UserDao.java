package com.nguyenxb.dao.user;

import com.nguyenxb.entity.User;

import java.sql.Connection;

public interface UserDao {
    // 获取登录用户对象
    User getLoginUser(Connection connection, String userCode);

    // 修改当前用户密码
    public int updatePwd(Connection connection, Integer id, String userPassword);
}
