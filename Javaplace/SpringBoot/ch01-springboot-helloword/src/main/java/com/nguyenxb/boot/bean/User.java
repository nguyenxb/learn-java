package com.nguyenxb.boot.bean;

import lombok.*;

@ToString // 声明 toString 方法
@Data // 声明 set,get方法 , 包含toString方法
@AllArgsConstructor // 声明 全参数的构造器
@NoArgsConstructor // 声明 无参数构造器
@EqualsAndHashCode // 声明 hashcode方法.
public class User {
    private String name;
    private Integer age;

}
