package com.nguyenxb;

import com.nguyenxb.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyTest {
    // 类名不要Test,否则与注解可能会发生冲突
    // 测试mybatis执行sql语句
    @Test
    public void testInsertStudent() throws IOException {
        // 定义mybatis主配置文件的位置
        String config = "mybatis.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(config);
        // 使用 sqlSessionFactoryBuilder的build方法 创建sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取 sqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建 sql id ,插入数据
        String sqlId = "com.nguyenxb.dao.StudentDao"+"."+"insertStudent";
        // 创建要插入数据的对象
        Student student = new Student();
        student.setId(1005);
        student.setName("阿瑟东");
        student.setEmail("asd@qq.com");
        student.setAge(23);
        // 执行插入操作
        int rows = sqlSession.insert(sqlId,student);
        // 提交事务
        sqlSession.commit();
        System.out.println("使用mybatis添加一个学生,rows:"+rows);

        sqlSession.close();
    }

    @Test
    public void testSelectStudentById() throws IOException {
        // 调用mybatis某个对象的方法,执行mapper文件中的sql语句
        // mybatis 核心类 : SqlSessionFactory

        // 1 定义mybatis主配置文件的位置,从类路径开始的相对路径
        String config = "mybatis.xml";
        // 2 读取主配置文件,使用mybatis框架中的Resources类
        InputStream inputStream = Resources.getResourceAsStream(config);
        // 3 创建SqlSessionFactory对象, 使用SqlSessionFactoryBuilder对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        // 4 获取 SqlSession对象
        SqlSession sqlSession = factory.openSession();

        // 5 指定要执行的sql语句的 id
        // sql的id = mapper的 namespace +"."+<select>|update|insert|delete标签的id属性
        String sqlId = "com.nguyenxb.dao.StudentDao"+"."+"selectStudentById";

        // 6 通过sqlSession 执行sql语句
        Student student = (Student)sqlSession.selectOne(sqlId,1001);

        System.out.println("使用mybatis查询:"+student.toString());

        // 7 关闭资源
        sqlSession.close();

    }
}
