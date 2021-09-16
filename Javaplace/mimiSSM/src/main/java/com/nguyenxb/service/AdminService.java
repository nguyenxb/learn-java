package com.nguyenxb.service;

import com.nguyenxb.pojo.Admin;

public interface AdminService {
    /**
     * @param name 用户输入的用户名
     * @param pwd   用户输入的密码
     * @return 数据库查到的管理员对象
     */
    Admin login(String name , String pwd);

}
