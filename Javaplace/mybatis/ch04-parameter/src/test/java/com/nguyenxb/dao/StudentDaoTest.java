package com.nguyenxb.dao;

import com.nguyenxb.entity.Student;
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
    public void testOneParameter(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectByEmail("as@qq.com");
        System.out.println(student.toString());
        sqlSession.close();
    }
  @Test
    public void testSelectByNameOfAge(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectByNameOrAge("阿迪",23);
       students.forEach(student -> System.out.println(student.toString()));
        sqlSession.close();
    }
 @Test
    public void testSelectByObject(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("阿瑟东");
        student.setAge(15);
        List<Student> students = dao.selectByObject(student);
       students.forEach(student1 -> System.out.println(student1.toString()));
        sqlSession.close();
    }
    @Test
    public void testSelectByPosition(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectByPosition("阿瑟东",15);
       students.forEach(student1 -> System.out.println(student1.toString()));
        sqlSession.close();
    }
 @Test
    public void testSelectByObject2(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        QueryParam queryParam = new QueryParam();
        queryParam.setP1("阿瑟东");
        queryParam.setP2(15);
        List<Student> students = dao.selectByObject2(queryParam);
       students.forEach(student1 -> System.out.println(student1.toString()));
        sqlSession.close();
    }
@Test
    public void testSelectByMap(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<String,Object> map = new HashMap<>();
        map.put("myname","哈哈");
        map.put("myage",23);

        List<Student> students = dao.selectStudentByMap(map);
       students.forEach(student1 -> System.out.println(student1.toString()));
        sqlSession.close();
    }


}
