package hander;

import service.SomeService;
import util.ServiceTool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;

public class MyInvocationHandler implements InvocationHandler {
    // 目标对象
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 通过代理对象执行方法时,会调用这个invoke()
        Object res = null;
        // 只有执行doSome()时, 才输出日志
        if ("doSome".equals(method.getName())){
            ServiceTool.doLog();
            // 执行目标类的方法,通过Method类实现
            res = method.invoke(target,args);// SomeServiceImpl.doSome() , doOther()
            ServiceTool.doTrans();
        }

        // 目标方法执行结果
        return res;
    }
}
