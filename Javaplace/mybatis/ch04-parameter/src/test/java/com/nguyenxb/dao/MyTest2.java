package com.nguyenxb.dao;

import com.nguyenxb.entity.Student;
import com.nguyenxb.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest2 {
    @Test
    public void testQueryStudent(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.queryStudent("'阿迪'");

        students.forEach(student -> System.out.println(student.toString()));
        sqlSession.close();

    }
        @Test
    public void testQueryStudentByColName(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.queryStudentByColName("id");

        students.forEach(student -> System.out.println(student.toString()));
        sqlSession.close();

    }
    @Test
    public void testQueryStudents(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.queryStudents("student",
                "阿迪","id");

        students.forEach(student -> System.out.println(student.toString()));
        sqlSession.close();

    }

}
