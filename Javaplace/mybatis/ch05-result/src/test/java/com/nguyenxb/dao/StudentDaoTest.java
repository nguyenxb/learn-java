package com.nguyenxb.dao;

import com.nguyenxb.entity.Student;
import com.nguyenxb.pojo.CustomObject;
import com.nguyenxb.pojo.QueryParam;
import com.nguyenxb.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void testSelectCustomObjectById(){
        // 获取 sqlSession操作数据
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        // 使用代理模式
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        CustomObject customObject = studentDao.selectCustomObjectById(1001);
        System.out.println(customObject.toString());
        sqlSession.close();
    }
  @Test
    public void testCountStudent(){
        // 获取 sqlSession操作数据
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        // 使用代理模式
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
      long countStudent = studentDao.countStudent();
      System.out.println("行数:"+countStudent);
        sqlSession.close();
    }
 @Test
    public void testSelectMap(){
        // 获取 sqlSession操作数据
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        // 使用代理模式
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
          Map<Object, Object> map = studentDao.selectMap(1005);
         System.out.println("map === "+map);
        sqlSession.close();
    }

    @Test
    public void selectCustomObjectById2(){
        // 获取 sqlSession操作数据
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        // 使用代理模式
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        CustomObject customObject = dao.selectCustomObjectById2(1001);
        System.out.println(customObject);
        sqlSession.close();
    }
    @Test
    public void testSelectLikeOne(){
        // 获取 sqlSession操作数据
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        // 使用代理模式
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        String name = "%阿%";
        List<Student> students = dao.selectLikeOne(name);
        students.forEach(student -> System.out.println(student));
        sqlSession.close();
    }
 @Test
    public void testSelectLikeTwo(){
        // 获取 sqlSession操作数据
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        // 使用代理模式
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        String name = "阿";
        List<Student> students = dao.selectLikeTwo(name);
        students.forEach(student -> System.out.println(student));
        sqlSession.close();
    }

}
