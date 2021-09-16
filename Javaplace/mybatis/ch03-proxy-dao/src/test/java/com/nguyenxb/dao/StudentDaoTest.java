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
        // 使用代理模式
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = studentDao.selectStudentById(1001);
        System.out.println(student.toString());
        sqlSession.close();
    }
    @Test
    public void testSelectStudents(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectStudents();
        for (Student student:students) {
            System.out.println(student.toString());
        }
        sqlSession.close();
    }
    @Test
    public void testInsertStudent(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(1008);
        student.setName("阿迪");
        student.setEmail("adi@qq.com");
        student.setAge(15);
        int rows = dao.insertStudent(student);
        sqlSession.commit();
        System.out.println("insert的行数=="+rows);

        sqlSession.close();
    }

}
