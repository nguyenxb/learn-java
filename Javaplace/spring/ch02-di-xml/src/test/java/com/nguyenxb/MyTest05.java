package com.nguyenxb;

import com.nguyenxb.ba05.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest05 {
    @Test
    public void test05(){
        String config = "applicationContext";
        // 创建spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 从容器中获取对象, 使用name属性创建的对象
        Student mystudent = (Student) ac.getBean("mystudent");

        System.out.println("student对象="+mystudent);

    }


}
