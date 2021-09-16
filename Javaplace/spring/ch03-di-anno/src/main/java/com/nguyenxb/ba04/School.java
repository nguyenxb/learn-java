package com.nguyenxb.ba04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("mySchool")
//@Component
public class School {

    @Value("04xxx学校")
    private String name;
    @Value("04xxx地址")
    private String address;

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
