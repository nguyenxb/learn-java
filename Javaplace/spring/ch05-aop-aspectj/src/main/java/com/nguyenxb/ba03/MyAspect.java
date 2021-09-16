package com.nguyenxb.ba03;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Date;


/**
 * @Aspect : 是aspectj框架中的注解.
 *      作用: 表示当前类是切面类.
 *      切面类: 是用来给业务方法增加功能的类, 在这个类中有切面的功能代码.
 *      位置:在类定义的上面
 */
@Aspect
public class MyAspect {
   /**
    * 环绕通知方法的定义格式
    *  1,public
    *  2,必须有一个返回值,推荐使用Object
    *  3,方法名称定义
    *  4,方法有参数,固定的参数 ProceedingJoinPoint
    * */

   /**
    * @Around: 环绕通知
    *   属性: value 切入点表达式
    *   位置: 在方法定义上面
    *
    *  特点:
    *    1. 他是功能最强的通知
    *    2. 在目标方法的前和后都能增强功能.
    *    3. 控制目标方法是否被调用执行.
    *    4. 修改原来的目标方法的执行结果. 影响最好的调用结果
    *
    *    环绕通知,等同与jdk的动态代理的,InvocationHandler接口
    *     参数: ProceedingJoinPoint 就等同于 Method
    *           作用 : 执行目标方法的
*           返回值 : 就是目标方法的执行结果,结果可以被修改
    *
    * 环绕通知经常做事务, 在目标放之前开启事务,执行目标方法之后提交事务.
    *
    *
    * */

    @Around(value = "execution(* *..SomeServiceImpl.doFirst(..))")
   public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // 获取目标类的第一个参数值
        Object args[] = proceedingJoinPoint.getArgs();
        for (Object arg: args){
            System.out.println("参数:"+arg);
        }

       // 实现环绕通知
        Object result = null;
        System.out.println("环绕通知: 在目标方法之前,输出时间:"+new Date());
        // 1. 目标方法的调用
        result = proceedingJoinPoint.proceed(); // 等同于method.invoke(); Object result = doFirst();
        System.out.println("环绕通知: 在目标方法之后,如提交事务");
        // 2. 在目标方法的前或者后加入功能

        // 返回目标方法的执行结果,可以改变结果,并且会影响返回的结果
        return result;

   }

}
