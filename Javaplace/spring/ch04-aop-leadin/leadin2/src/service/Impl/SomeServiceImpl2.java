package service.Impl;

import service.SomeService2;
import util.ServiceTool;

public class SomeServiceImpl2 implements SomeService2 {
    @Override
    public void doSome() {
//        ServiceTool.doLog();
        System.out.println("执行了业务方法doSome");
//        ServiceTool.doTrans();
    }

    @Override
    public void doOther() {
//        ServiceTool.doLog();
        System.out.println("执行了业务方法doOther");
//        ServiceTool.doTrans();
    }
}
