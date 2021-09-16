package com.nguyenxb;

import com.nguyenxb.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myTest02 {
    @Test
    public void test02(){
        String config = "ba02/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 从容器中获取对象 , 使用自定义对象名的注解
        Student myStudent = (Student) ac.getBean("myStudent");
        System.out.println(myStudent);
    }
}
