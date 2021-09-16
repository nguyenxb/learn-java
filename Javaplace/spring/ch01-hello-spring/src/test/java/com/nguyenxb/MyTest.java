package com.nguyenxb;

import com.nguyenxb.service.SomeService;
import com.nguyenxb.service.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {
    @Test
    public void test01(){
        SomeService someService = new SomeServiceImpl();
        someService.doSome();
    }
    /*
    * spring 默认创建对象的时间: 在创建spring的容器时,会创建配置文件中的所有对象.
    * spring 创建对象, 默认调用的是无参数构造方法.
    * */
    @Test
    public void test02(){
        // 使用spring 容器创建的对象
        // 1. 指定spring配置文件的名称
        String config = "beans.xml";
        // 2. 创建表示spring 容器的对象. ApplicationContext
        // ApplicationContext就是表示spring容器,就能通过容器获取对象了.
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        // 3. 从容器获取某个对象,你要调用对象的方法.
        // getBean("配置文件中bean的id的值")
        SomeService someService = (SomeService) ac.getBean("someService");

        // 4. 使用spring 创建好的对象
        someService.doSome();

    }

    /**
     * 获取spring容器中, java对象的信息
     * */
    @Test
    public void test03(){
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 使用spring提供的方法, 获取容盎中定义的对象的数量.
        int nums = ac.getBeanDefinitionCount();
        System.out.println("容器中定义的对象数量:"+nums);
        // 容器中每个定义的对象的名称
        String[] names = ac.getBeanDefinitionNames();
        for (String name: names){
            System.out.println("对象名称:"+name);
        }
    }

    // 创建非自定义的对象
    @Test
    public void test04(){
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        // 使用getBean();
        Date mydate = (Date) ac.getBean("mydate");
        System.out.println("Date:"+mydate);
    }
}
