package com.nguyenxb;

import com.nguyenxb.dao.StudentDao;
import com.nguyenxb.entity.Student;
import com.nguyenxb.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        String[] names = ac.getBeanDefinitionNames();
        for (String name:names){
            System.out.println("容器中对象名称:"+name+"---|---" + ac.getBean(name).getClass());
        }

    }
    @Test
    public void testInsertStudent(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        StudentDao studentDao = (StudentDao) ac.getBean("studentDao");
        Student student = new Student(1009,"张伟","zhangwei@qq.com",20);
        int row = studentDao.insertStudent(student);
        System.out.println(row);
    }
    @Test
    public void testServiceInsert(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        StudentService studentService = (StudentService) ac.getBean("studentService");
        Student student = new Student(1010,"李双","zhangwei@qq.com",20);
        int row = studentService.addStudent(student);
//        spring和mybatis整合在一起使用,事务是自动提交的,无需执行sqlSession.commit()
        System.out.println(row);
    }

    @Test
    public void testSelectStudents(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        StudentService studentService = (StudentService) ac.getBean("studentService");
        List<Student> students = studentService.queryStudents();
        for (Student student: students){
            System.out.println(student);
        }
    }
}
