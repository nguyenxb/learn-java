package com.nguyenxb.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.nguyenxb.boot.bean.Car;
import com.nguyenxb.boot.bean.Pet;
import com.nguyenxb.boot.bean.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 *  1. 配置类里面使用 @Bean 标注在方法上给容器注册组件,默认也是单实例的.
 *  2. 配置类也是本身也是组件
 *  3. proxyBeanMethods : 代理 bean 的方法
 *      Full: @Configuration(proxyBeanMethods = true) , 单例模式
 *          外部无论对配置类中的这个注册方法调用多少次, 获取的都是 之前注册容器中的单实例对象.
 *      Lite : @Configuration(proxyBeanMethods = false) , 多实例模式.
 *          外部无论对配置类中的这个注册方法调用多少次, 获取的都是 新创建的实例对象.
 *   4.  @Import({User.class,Pet.class })
 *          给容器中自动创建出两个类型的组件,默认的组件名字就是全类名.
 *
 */
// @Configuration:告诉springboot 这是一个配置类, 即配置文件
    @Import({User.class, Pet.class})
    @ImportResource("classpath:beans.xml")
    @EnableConfigurationProperties(Car.class)
@Configuration(proxyBeanMethods = true)
public class MyConfig {

    /*
        外部无论对配置类中的这个注册方法调用多少次, 获取的都是 之前注册容器中的单实例对象.
    *
    * */

    /**
     * @Bean  给容器中添加组件. 以方法名作为组件的id,返回类型是组件的类型,
     * 返回值就是组件在容器中的实例
     */
    @Bean
    public User user01(){
        User zhangsan = new User("zhangsan",20);
//        zhangsan.setPet();
        return zhangsan;
    }


    /**
     *
     */
    @Bean("tomcatPet")
    public Pet tomcat(){
        return new Pet("tom");
    }
}
