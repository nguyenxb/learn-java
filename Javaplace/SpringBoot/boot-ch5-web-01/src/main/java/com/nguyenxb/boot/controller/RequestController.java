package com.nguyenxb.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {
    @GetMapping("/reqGoto")
    public String reqGoto(HttpServletRequest request){
        request.setAttribute("msg","成功处理请求");
        request.setAttribute("code",200);
        return "forward:/success";
    }

    @GetMapping("/success")
    @ResponseBody
    public Map success(@RequestAttribute("msg") String msg,
                       @RequestAttribute("code") Integer code,
                       HttpServletRequest request){

        String msg1 = (String) request.getAttribute("msg");
        Integer code1 = (Integer) request.getAttribute("code");


        System.out.println("msg : "+msg);
        System.out.println("code : "+code);
        System.out.println("=================");
        System.out.println("msg1 : "+msg1);
        System.out.println("code1 : "+code1);

        Map<String,Object> map = new HashMap<>();
        map.put("msg",msg);
        map.put("code",code);
        map.put("msg1",msg1);
        map.put("code1",code1);

        return map;
    }
}
