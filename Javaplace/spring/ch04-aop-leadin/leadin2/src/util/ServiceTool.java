package util;

import java.util.Date;

public class ServiceTool {
    public static void doLog(){
        System.out.println("非业务功能,日志功能,在方法开始是输出日志"+new Date());
    }
    public static void doTrans(){
        System.out.println("非业务事务功能,在方法执行后,加入事务");
    }
}
