package com.nguyenxb.ba04;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
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
   *  异常通知方法的定义格式:
    *   1.public
    *   2.没有返回值
    *   3.方法名称自定义
    *   4.方法有一个Exception,如果还有就是JoinPoint
    *
   * */

   /**
    * @AfterThrowing : 异常通知
    *   属性: 1.value 切入点表达式
    *       2. throwing 自定义变量名, 表示目标方法抛出的异常对象,
    *           变量名必须和方法的参数名一样
    *
    *   执行类比于:
    *       try{
    *           doSecond()
    *       }catch(Exception ex){
    *                  System.out.println("异常通知: 方法发生异常时, 执行: "+ex);
    *       }
    *
    * */

   @AfterThrowing(value = "execution(* *..doSecond(..))",throwing = "ex")
   public void myAfterThrowing(Exception ex){
       System.out.println("异常通知: 方法发生异常时, 执行: "+ex);
       // 发生邮件,或者短信通知开发人员
   }

}
