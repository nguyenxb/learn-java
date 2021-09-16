package com.nguyenxb.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        return "get 张三";
    }
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String postUser(){
        return "post 张三";
    }
@RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "delete 张三";
    }
@RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String putUser(){
        return "put 张三";
    }




}
