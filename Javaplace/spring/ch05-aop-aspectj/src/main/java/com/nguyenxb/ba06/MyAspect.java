package com.nguyenxb.ba06;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


/**
 * @Aspect : 是aspectj框架中的注解.
 *      作用: 表示当前类是切面类.
 *      切面类: 是用来给业务方法增加功能的类, 在这个类中有切面的功能代码.
 *      位置:在类定义的上面
 */
@Aspect
public class MyAspect {
 /**
  * 最终通知方法的定义格式
  *  1.public
  *  2. 没有返回值
  *  3.方法名称自定义
  *  4. 方法没有参数 , 如果还有是JoinPoint,
  *
  * */

 /**
  * @After : 最终通知
  *     属性: value 切入点表达式
  *     位置: 在方法的上面
  *  特点:
  *     1. 总是会执行
  *     2. 在目标方法之后执行的
  *
  *
  *     其实执行就等价于
  *      try{
  *
  *      }catch(Exception e){
  *
  *      }finally{
  *
  *      }
  * */

// @After(value = "execution(* *..SomeServiceImpl.doThird(..))")
    @After(value = "myPointcut()")
    public void myAfter(){
     System.out.println("执行最终通知,总是会被执行的代码");
     // 一般是做资源清除工作的.

 }
// @Before(value = "execution(* *..SomeServiceImpl.doThird(..))")
    @Before(value = "myPointcut()")
    public void myBefore(){
     System.out.println("前置通知,总是在目标方法之前执行");
     // 一般是做资源清除工作的.

 }
 /**
  * @Pointcut : 定义和管理切入点, 如果项目中有多个切入点表达式是重复的,可以复用的,
  *         那么可以使用 @Pointcut
  *      属性: value  切入点表达式
  *      位置: 在自定义的方法的上面
  *    特点: 当使用 @Pointcut定义在一个方法的上面,次数这个方法的名称就是切入点的别名
  *     其他的通知值,value属性就可以使用这个方法的名称代替切入点表达式了
  *
  * */


 @Pointcut(value = "execution(* *..SomeServiceImpl.doThird(..))")
    public void myPointcut(){}

}
