import hander.MyInvocationHandler;
import service.Impl.SomeServiceImpl;
import service.SomeService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main1 {
    public static void main(String[] args) {
        // 使用jad的Proxy创建代理对象
        // 创建目标对象
        SomeService target =  new SomeServiceImpl();

        // 创建InvocationHandler对象
        InvocationHandler handler = new MyInvocationHandler(target);

        // 使用Proxy创建代理
        /*
        * 传入参数:
        * 1, 目标类的类加载器
        * 2,目标类实现的接口
        * 3,代理对象,要执行的功能
        * */
        SomeService proxy = (SomeService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler);
        // 通过代理对象执行业务方法,会调用handler中的invoke(),即实现日志,事务的增强
        proxy.doSome();
        System.out.println("==============================");
        proxy.doOther();
    }
}
