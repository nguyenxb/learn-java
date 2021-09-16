package com.nguyenxb.dao.user;

import com.nguyenxb.dao.BaseDao;
import com.nguyenxb.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{
    // 得到登录的用户信息
    public User getLoginUser(Connection connection, String userCode) {
        PreparedStatement psmt = null;
        ResultSet rs = null;
        User user = null;
        // 连接不为空则查询
        if(connection != null){
            String sql = "select * from smbms_user where userCode=?";
            Object[] params = {userCode};
            rs = BaseDao.execute(connection,psmt,rs,sql,params);

            try {
                // 读取到数据,就将数据存入User对象,并关闭连接
                if(rs.next()){
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUserCode(rs.getString("userCode"));
                    user.setUserName(rs.getString("userName"));
                    user.setUserPassword(rs.getString("userPassword"));
                    user.setGender(rs.getInt("gender"));
                    user.setBirthday(rs.getDate("birthday"));
                    user.setPhone(rs.getString("phone"));
                    user.setAddress(rs.getString("address"));
                    user.setUserRole(rs.getInt("userRole"));
                    user.setCreatedBy(rs.getInt("createdBy"));
                    user.setCreationDate(rs.getTimestamp("creationDate"));
                    user.setModifyBy(rs.getInt("modifyBy"));
                    user.setModifyDate(rs.getTimestamp("modifyDate"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                BaseDao.closeResource(connection,psmt,rs);
            }
        }
        return user;
    }


    // 修改当前用户密码
    public int updatePwd(Connection connection, Integer id, String userPassword) {
        PreparedStatement pstm = null;
        // update 数据库更新操作返回的结果
        int update = 0;
        if (connection != null){
            String sql = "update smbms_user set userPassword = ? where id = ?";
            try {
                pstm = connection.prepareStatement(sql);
                Object[] params = {userPassword,id};
                update = BaseDao.execute(connection,pstm,sql,params);

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                BaseDao.closeResource(connection,pstm,null);
            }
        }
        return update;
    }
}
