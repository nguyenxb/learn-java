package com.nguyenxb.boot.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
}
