package com.nguyenxb.service.impl;

import com.nguyenxb.mapper.AdminMapper;
import com.nguyenxb.pojo.Admin;
import com.nguyenxb.pojo.AdminExample;
import com.nguyenxb.service.AdminService;
import com.nguyenxb.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

//   在业务逻辑层一定会有数据库访问层的对象.使用 类型自动注入
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(String name, String pwd) {
        // 根据传入的用户名 到 数据库中查找响应的用户对象
        // AdminExample 是用来封装sql语句条件的对象,
        AdminExample adminExample = new AdminExample();
        // 完成sql语句查询条件的拼接 : select * from admin where a_name="aName"
        adminExample.createCriteria().andANameEqualTo(name);

        // 如果查询到用户对象,则进行密码对比
        List<Admin> adminList = adminMapper.selectByExample(adminExample);
        if (adminList.size() > 0){
            Admin admin = adminList.get(0);
            String md5Pwd = MD5Util.getMD5(pwd);
            if (admin.getaPass().equals(md5Pwd)){
                return admin;
            }
        }
        return null;
    }
}
