package com.nguyenxb;

import com.nguyenxb.ba07.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest07 {
    @Test
    public void test07(){
        String config = "ba07/total.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        Student myStudent = (Student) ac.getBean("mystudent");

        System.out.println(myStudent);

    }
}
