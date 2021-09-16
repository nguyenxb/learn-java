package com.nguyenxb;

import com.nguyenxb.ba03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class MyTest03 {
    @Test
    public void test03(){
        String config = "ba03/applicationContext.xml";
        // 创建spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 从容器中获取对象, 使用name属性创建的对象
        Student mystudent = (Student) ac.getBean("mystudent");

        System.out.println("使用name创建student对象="+mystudent);

        // 从容器中获取对象,使用index属性创建的对象
        Student mystudent2 = (Student) ac.getBean("mystudent2");

        System.out.println("使用index创建student对象="+mystudent2);

        // 从容器中获取对象,直接省略index而创建的对象
        Student mystudent3 = (Student) ac.getBean("mystudent3");

        System.out.println("省略index创建student对象="+mystudent3);

    }

    @Test
    public void test04(){
        String config = "ba04/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        File myfile = (File) ac.getBean("myfile");
        System.out.println("文件名称:"+myfile.getName());
    }

}
