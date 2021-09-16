package com.nguyen.text;

import java.sql.*;

public class test {
    public static void main(String[] args) {
        // 解决字符编码问题
        String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=true&useUnicode=true&" +
                "characterEncoding=utf-8";
        String user = "root";
        String password = "root";

        try {
//        1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
//        2.连接数据库
            Connection conn = DriverManager.getConnection(url,user,password);

//        3.向数据库发生SQL的对象，PrepareStatement :CURD
            String sql = "select * from users";
            PreparedStatement statement = conn.prepareStatement(sql);


//        5.执行查询语句
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password1 = resultSet.getString("password");
                String email = resultSet.getString("email");
                Date birthday = resultSet.getDate("birthday");
                System.out.println("id="+id);
                System.out.println("name="+name);
                System.out.println("password="+password1);
                System.out.println("email="+email);
                System.out.println("birthday="+birthday);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
