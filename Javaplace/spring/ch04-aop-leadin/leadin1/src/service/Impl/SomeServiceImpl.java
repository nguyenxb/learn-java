package service.Impl;

import service.SomeService;

import java.util.Date;

public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
//        doLog();
        System.out.println("执行了业务方法doSome");
//        doTrans();
    }

    @Override
    public void doOther() {
//        doLog();
        System.out.println("执行了业务方法doOther");
//        doTrans();
    }
    public void doLog(){
        System.out.println("非业务功能,日志功能,在方法开始是输出日志"+new Date());
    }
    public void doTrans(){
        System.out.println("非业务事务功能,在方法执行后,加入事务");
    }
}
