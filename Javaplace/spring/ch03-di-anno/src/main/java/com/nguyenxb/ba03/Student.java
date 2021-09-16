package com.nguyenxb.ba03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
                ", school=" + school +
                '}';
    }

    /*
        引用类型
    * @Autowired: spring 中通过注解给引用类型赋值, 使用的是自动注入的原理.支持byName, byType,
    * @Autowired:默认使用的是byType自动注入
         @Autowired 的属性: required, 是一个boolean 类型的,默认true
            required=true : 表示引用类型赋值失败,程序报错,并终止执行
            required=false: 表示 引用类型如果赋值失败.程序正常执行,引用类型是null
            用法: @Autowired(required=true)
    *
    * 位置: 1.在属性定义的上面,无需set方法,推荐使用
    *   2.在set方法上面
    *
    * 如果要使用byName方式,需要做的是:
    *   1.在属性上面加入 @Autowired
    *   2.在属性上面加入@Qualifier(value="bean的id"):
    *         表示使用指定名称的bean完成赋值.
    *
    * */

    // 两个没有先后顺序, 按名称
    @Autowired
    @Qualifier("mySchool")// 即不使用这个就是默认的byType,
    private School school;

    @Value("24")
    public void setAge(int age) {
        this.age = age;
    }
}
