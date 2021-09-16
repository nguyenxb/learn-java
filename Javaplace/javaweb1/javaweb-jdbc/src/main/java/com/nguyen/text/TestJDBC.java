package com.nguyen.text;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBC {

    @Test
    public void hello(){
        String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=true&useUnicode=true&" +
                "characterEncoding=utf-8";
        String user = "root";
        String password = "root";
        String Driver = "com.mysql.jdbc.Driver";
        Connection conn = null;
        try {
            Class.forName(Driver);
            conn = DriverManager.getConnection(url, user, password);
            // 关闭自动提交事务
            conn.setAutoCommit(false);

            String sql = "UPDATE account set money = money - 100 WHERE name = 'A'";
            conn.prepareStatement(sql).executeUpdate();

            String sql1 = "UPDATE account set money = money + 100 WHERE name = 'B'";
            conn.prepareStatement(sql1).executeUpdate();

            int i =1/0;

            // 提交事务
            conn.commit();
            System.out.println("提交成功");
        } catch (Exception e) {
            // 如果出现异常则回滚事务
            try {
                assert conn != null;
                conn.rollback();
                System.out.println("提交失败");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            try {
                conn.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            e.printStackTrace();
        }

    }
}
