package com.nguyenxb;

import com.nguyenxb.ba05.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest05 {
    @Test
    public void test05(){
        String config = "ba05/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student myStudent = (Student) ac.getBean("MyStudent");
        System.out.println(myStudent);
    }
}
