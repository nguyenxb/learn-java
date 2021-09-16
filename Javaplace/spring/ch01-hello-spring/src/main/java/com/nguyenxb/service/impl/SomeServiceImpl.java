package com.nguyenxb.service.impl;

import com.nguyenxb.service.SomeService;

public class SomeServiceImpl implements SomeService {
    public SomeServiceImpl(){
        System.out.println("SomeServiceImpl的构造方法执行了");
    }

    @Override
    public void doSome() {
        System.out.println("执行SomeServiceImpl的doSome()方法");
    }
}
