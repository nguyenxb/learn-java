package com.nguyenxb.dao;

import com.nguyenxb.entity.Student;
import com.nguyenxb.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentDaoTest {
    @Test
    public void testSelectStudentById(){
        // 获取 sqlSession操作数据
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        // 创建sqlId
        String sqlId = "com.nguyenxb.dao.StudentDao.selectStudentById";
        Student student = sqlSession.selectOne(sqlId, 1001);
        System.out.println(student.toString());
        sqlSession.close();
    }
    @Test
    public void testSelectStudents(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String sqlId = "com.nguyenxb.dao.StudentDao.selectStudents";
        List<Student> list = sqlSession.selectList(sqlId);
        for (Student student:list) {
            System.out.println(student.toString());
        }
        sqlSession.close();
    }
    @Test
    public void testInsertStudent(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String sqlId = "com.nguyenxb.dao.StudentDao.insertStudent";
        Student student = new Student();
        student.setId(1006);
        student.setName("阿迪");
        student.setEmail("adi@qq.com");
        student.setAge(15);
        int rows = sqlSession.insert(sqlId, student);
        sqlSession.commit();
        System.out.println("insert的行数=="+rows);

        sqlSession.close();
    }

}
