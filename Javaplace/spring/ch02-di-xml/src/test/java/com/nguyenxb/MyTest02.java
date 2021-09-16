package com.nguyenxb;

import com.nguyenxb.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest02 {
    @Test
    public void test02(){
        String config = "ba02/applicationContext.xml";
        // 创建spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 从容器中获取对象
        Student mystudent = (Student) ac.getBean("mystudent");

        System.out.println("student对象="+mystudent);
    }

}
