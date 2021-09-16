package com.nguyenxb.dao;

import com.github.pagehelper.PageHelper;
import com.nguyenxb.entity.Student;
import com.nguyenxb.pojo.CustomObject;
import com.nguyenxb.pojo.QueryParam;
import com.nguyenxb.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDaoTest {
    @Test
    public void selectIf(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
         // 测试1 : 查询成功:查询 名字是阿迪的或者年龄小于20的
        // mybatis生成的sql语句:select * from student where name = ? or age < ?
        student.setName("阿迪");
        student.setAge(20);

        // 测试2 : 查询成功
        // mybatis生成的sql语句:select * from student where name = ?
//        student.setName("阿迪");

        // 测试3 : 查询失败, sql语句语法错误 :
        //mybatis生成的sql语句 : select * from student where or age > 20
//        student.setName(null);
//        student.setAge(20);

        List<Student> students = dao.selectIf(student);
        students.forEach(stu -> System.out.println(stu));
        sqlSession.close();
    }
      @Test
    public void selectWhere(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
         // 测试1 : 查询成功, :查询 名字是阿迪的或者年龄大于20的
          // mybatis生成的sql语句 :select * from student WHERE name = ? or age > ?
        student.setName("阿迪");
        student.setAge(20);

          // 测试2: 查询成功
          //mybatis生成的sql语句 : select * from student WHERE name = ?
//          student.setName("阿迪");

        // 测试3 : 查询成功
          // mybatis生成的sql语句 :select * from student WHERE age > ?
        student.setName(null);
        student.setAge(20);

        List<Student> students = dao.selectWhere(student);
        students.forEach(stu -> System.out.println(stu));
        sqlSession.close();
    }

    @Test
    public void testForEach(){
        List<Integer> idList = new ArrayList<>();
        idList.add(1001);
        idList.add(1002);
        idList.add(1003);

        // 拼接sql语句
        StringBuilder sb = new StringBuilder();
        sb.append("select * from student where id in ");
        sb.append("(");
        // 追加idList的数据到sql字符串
        for (int i = 0; i < idList.size(); i++) {
            // 获取idList中的成员
            Integer item = idList.get(i);
            sb.append(item);
            sb.append(",");
        }
        // 将数据后面的最后一个逗号删除
        sb.deleteCharAt(sb.length()-1);
        sb.append(")");
        System.out.println(sb);

    }
    @Test
    public void selectForeach1(){
        List<Integer> idList = new ArrayList<>();
        idList.add(1001);
        idList.add(1002);
        idList.add(1003);

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectForeach1(idList);
        students.forEach(stu-> System.out.println(stu));
        sqlSession.close();

    }
 @Test
    public void selectForeach2(){
        List<Student> idList = new ArrayList<>();
     Student student = new Student();
     Student student1 = new Student();
     student.setId(1004);
     student1.setId(1005);
     idList.add(student);
     idList.add(student1);

     SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectForeach2(idList);
        students.forEach(stu-> System.out.println(stu));
        sqlSession.close();
    }

    @Test
    public void testSelectAllStudents(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //调用PageHelper的方法
        PageHelper.startPage(2,3);
        List<Student> students = dao.selectAllStudents();
        students.forEach(stu-> System.out.println(stu));
        sqlSession.close();
    }
}
