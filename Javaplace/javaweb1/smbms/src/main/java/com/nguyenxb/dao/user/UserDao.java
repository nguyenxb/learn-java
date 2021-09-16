package com.nguyenxb.dao.user;

import com.nguyenxb.entity.User;

import java.sql.Connection;

public interface UserDao {
    // 获取登录用户对象
    User getLoginUser(Connection connection, String userCode);

}
