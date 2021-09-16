package com.nguyenxb.boot.config;

import com.nguyenxb.boot.bean.Car;
import com.nguyenxb.boot.bean.Pet;
import com.nguyenxb.boot.bean.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ConditionalOnBean(name="tom22")

@Configuration
public class MyConfig1 {
    @Bean
    public Pet tom(){
        return new Pet() ;
    }
    @Bean
    public User user01(){
        return new User("asd",12) ;
    }
    
}
