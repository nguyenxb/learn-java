package com.nguyenxb.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("pet")
@Component
@Data
public class Pet {
    private String name;
    private Double weight;
}
