package com.nguyenxb.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan(basePackages = "com.nguyenxb.boot")
@SpringBootApplication
public class BootCh5WebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootCh5WebAdminApplication.class, args);
    }

}
