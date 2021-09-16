package com.nguyenxb.ba03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("mySchool")
//@Component
public class School {

    @Value("03xxx学校")
    private String name;
    @Value("03xxx地址")
    private String address;

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
