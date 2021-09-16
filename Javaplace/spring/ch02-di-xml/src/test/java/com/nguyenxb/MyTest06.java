package com.nguyenxb;

import com.nguyenxb.ba06.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest06 {
    @Test
    public void test06(){
        String config = "ba06/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        Student myStudent = (Student) ac.getBean("mystudent");

        System.out.println(myStudent);

    }
}
