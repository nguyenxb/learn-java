package com.nguyenxb.ba05;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("mySchool")
//@Component
public class School {

    @Value("05xxx学校")
    private String name;
    @Value("${schoolAddress}")
    private String address;

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
