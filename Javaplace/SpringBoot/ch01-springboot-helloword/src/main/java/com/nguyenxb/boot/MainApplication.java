package com.nguyenxb.boot;

import com.nguyenxb.boot.bean.Pet;
import com.nguyenxb.boot.bean.User;
import com.nguyenxb.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.net.Socket;
import java.util.Map;

/**
 * 主程序类
 * @SpringBootApplication：这是一个SpringBoot应用
 */
@SpringBootApplication // 这个注解包含了下面三个注解
//@EnableAutoConfiguration
//@SpringBootConfiguration
//@ComponentScan("com.nguyenxb.boot") // 这是组件扫描的包
public class MainApplication {

    public static void main(String[] args) {

        // 1. 返回ioc 容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        // 2. 查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name :
                names) {
            System.out.println(name);
        }

        // 3, 从容器中获取组件
        Pet tom01 = run.getBean("tomcatPet", Pet.class);

        Pet tom02 = run.getBean("tomcatPet", Pet.class);

        System.out.println("Pet 组件 :" +(tom01==tom02)); // Pet 组件 :true

        // 4.如果 设置@Configuration(proxyBeanMethods = true)代理对象调用方法
        // springboot 总是会检查容器中是否存在该组件.保证组件的唯一性
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        User user01 = bean.user01();
        User user = bean.user01();
        System.out.println("user :"+(user==user01));

//        5. 获取容器中的组件
        String[] beansOfType = run.getBeanNamesForType(User.class);
        for (String name :
                beansOfType) {
            System.out.println("user:"+name);
        }
        String[] beansOfType1 = run.getBeanNamesForType(Pet.class);
        for (String name : beansOfType1){
            System.out.println("pet:"+name);
        }

        User user1 = run.getBean("user01",User.class);
        System.out.println(user1.toString());

    }
}