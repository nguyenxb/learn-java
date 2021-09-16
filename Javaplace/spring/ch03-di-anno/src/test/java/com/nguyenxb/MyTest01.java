package com.nguyenxb;

import com.nguyenxb.ba01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest01 {
    @Test
    public void test01(){
        String config = "ba02/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 从容器中获取对象 , 使用自定义对象名的注解
        Student myStudent = (Student) ac.getBean("myStudent");
        System.out.println(myStudent);

        // 从容器中获取对象 : 使用spring默认的注解
//        Student student = (Student) ac.getBean("student");
//        System.out.println(student);
    }

}
