package com.nguyenxb.ba04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("myStudent")
public class Student {
    @Value("张五")
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
//    @Resource //先使用byName自动注入,如果byName注入失败,再使用byType
    @Resource(name="mSchool")//只使用byName自动注入,如果找不到,直接报错
    private School school;

    @Value("30")
    public void setAge(int age) {
        this.age = age;
    }
}
