package com.nguyenxb.service.user;

import com.nguyenxb.entity.User;

public interface UserService {
    // 用户登录
    public User login(String userCode, String password);

    public boolean updatePwd(Integer id,String password);
}
