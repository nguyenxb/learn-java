package com.nguyenxb.ba02;

// 目标类
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String name, Integer age) {
        // 给doSome方法增加一个功能,在doSome()执行之前,输出方法的执行时间.
        System.out.println("=====目标方法doSome()执行========"+name+":"+age);
    }

    @Override
    public String doOther(String name, Integer age) {
        System.out.println("=====目标方法doOther()执行====="+name+":"+age);
        return "abc";
    }
}