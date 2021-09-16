package com.nguyenxb.dao;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

//基础公共类
public class BaseDao {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    // 静态代码块，类加载的时候就初始化了
    static {
        Properties properties = new Properties();
        // 通过类加载器读取对应的资源
//        InputStream is = BaseDao.class.getResourceAsStream("db.properties");
        InputStream is = null;
        // 在当前项目下从同级根目录（java,resources）中搜索该文件
        is = BaseDao.class.getResourceAsStream("/db.properties");
//        System.out.println(is);
        try {
            // 将文件数据加载到properties对象
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = properties.getProperty("driver");
        url=properties.getProperty("url");
        user=properties.getProperty("user");
        password = properties.getProperty("password");

    }

    //获取数据库的链接
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    // 编写查询公共方法
    public static ResultSet execute(Connection connection,PreparedStatement preparedStatement ,ResultSet resultSet,String sql,Object[] params){
        try {
             preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                // 占位符从1开始，但数组从0开始
                preparedStatement.setObject(i+1,params[i]);
            }
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    // 增删改公共方法
    public static int execute(Connection connection,PreparedStatement preparedStatement, String sql, Object[] params){
        int updateRows = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0;i < params.length; i++){
                // 占位符从1开始，但数组从0开始
                preparedStatement.setObject(i+1,params[i]);
            }
            updateRows = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return updateRows;
    }
    public static boolean closeResource(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet) {
        boolean flag = true;
        if (resultSet != null){
            try {
                resultSet.close();
                // GC回收
                resultSet = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }
        if (preparedStatement != null){
            try {
                preparedStatement.close();
                preparedStatement = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }
        if (connection != null){
            try {
                connection.close();
                connection = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }
        return flag;
    }

}
