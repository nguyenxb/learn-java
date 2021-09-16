package com.nguyenxb.ba01;

import org.springframework.stereotype.Component;

/**
 * @Component: 创建对象的 等同于<bean>的功能
 *      属性: value 就是对象的名称, 也就是bean的id值
 *             value的值是唯一的.创建的对象在整个spring容器中就一个
 *      位置: 写在类的上面
 *
 * 1. @component(value="myStudent") 等同于
 * <bean id="myStudent" class="com.nguyenxb.ba01.Student"></bean>
 *
 * 2. 可以将value省略即: @component("myStudent")
 *
 * 3.也可以使用spring的默认注解
 * @component
 * 等价于: <bean id="student" class="com.nguyenxb.ba01.Student"></bean>
 *
 *
 *
 *
 * */

@Component(value = "myStudent")

public class Student {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

