package com.nguyenxb.ba02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myStudent")
public class Student {

    /*
        @Value : 给简单类型的属性赋值
            属性: value 是String类型的.表示简单类型的属性值.
            位置: 1.在属性定义的上面,无需set方法,推荐使用
                2.在set方法上面
    */
    @Value("张三")
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    @Value("24")
    public void setAge(int age) {
        this.age = age;
    }
}
