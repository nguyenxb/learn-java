package com.nguyenxb.boot.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {
    @GetMapping("/user/car/{id}/owner/{username}")
    public Map<String,Object> test1(@PathVariable("id") Integer id,
                                     @PathVariable("username") String username,
                                     @PathVariable Map<String,String> pv){

        System.out.println("id : "+id);
        System.out.println("username: "+username);
        for (String key : pv.keySet()) {
            String value = pv.get(key);
            System.out.println("pv == "+key+":::"+value);
        }
        /*
        *  输出 :
                    id : 1
                    username: 张三
                    pv == id:::1
                    pv == username:::张三
        * */

        Map<String,Object> map = new HashMap<>();

        map.put("id",id);
        map.put("username",username);
        map.put("pv",pv);

        return map;
    }

    @GetMapping("/user2/car/{id}/owner/{username}")
    public Map<String,Object> test2(@PathVariable("id") Integer id,
                                    @PathVariable("username") String username,
                                    @PathVariable Map<String,String> pv,

                                    @RequestHeader("User-Agent") String user_agent,
                                    @RequestHeader Map<String,String> reqHeader){

        System.out.println("id : "+id);
        System.out.println("username: "+username);
        for (String key : pv.keySet()) {
            String value = pv.get(key);
            System.out.println("pv == "+key+":::"+value);
        }
        System.out.println("==========================");
        System.out.println("user_agent : "+user_agent);
        for (String key : reqHeader.keySet()) {
            String value = reqHeader.get(key);
            System.out.println("reqHeader == "+key+":::"+value);
        }
        /*
        *  输出 :
                    id : 1
                    username: 张三
                    pv == id:::1
                    pv == username:::张三
        * */

        Map<String,Object> map = new HashMap<>();

        map.put("id",id);
        map.put("username",username);
        map.put("pv",pv);

        map.put("user-agent",user_agent);
        map.put("request_header",reqHeader);
        return map;
    }

    @GetMapping("/user3/car/{id}/owner/{username}")
    public void test3(@PathVariable("id") Integer id,
                                    @PathVariable("username") String username,
                                    @PathVariable Map<String,String> pv,

                                    @RequestParam("age") Integer age,
                                    @RequestParam("inters") List<String> inters,
                                    @RequestParam Map<String,String> reqParam){

        System.out.println("id : "+id);
        System.out.println("username: "+username);
        for (String key : pv.keySet()) {
            String value = pv.get(key);
            System.out.println("pv == "+key+":::"+value);
        }
        System.out.println("==========================");
        System.out.println("age : "+age);
        inters.forEach(inter -> System.out.println("inter : "+inter));
        for (String key : reqParam.keySet()) {
            String value = reqParam.get(key);
            System.out.println("reqParam == "+key+":::"+value);
        }
        /*
        *  输出 :
                    id : 1
                    username: 张三
                    pv == id:::1
                    pv == username:::张三
        * */
    }
    @GetMapping("/user4/car/{id}/owner/{username}")
    public void test4(@PathVariable("id") Integer id,
                      @PathVariable("username") String username,
                      @PathVariable Map<String,String> pv,

                      @CookieValue("Idea-480fa3ba") String cookieStr,
                      @CookieValue("Idea-480fa3ba") Cookie cookie){

        System.out.println("id : "+id);
        System.out.println("username: "+username);
        for (String key : pv.keySet()) {
            String value = pv.get(key);
            System.out.println("pv == "+key+":::"+value);
        }
        System.out.println("==========================");
        System.out.println("cookieStr : "+ cookieStr);
        System.out.println("cookie :"+ cookie.toString());
        /*
        *  输出 :
                   id : 4
                    username: 赵六
                    pv == id:::4
                    pv == username:::赵六
                    ==========================
                    cookieStr : 4d5cbe6a-5240-401f-b963-e5f8a5c271cc
                    cookie :javax.servlet.http.Cookie@5fee8fa1
        * */
    }

    @PostMapping("/user5")
    public void postTest5(@RequestBody String context){
        // 获取请求体的数据
        System.out.println(context);

    }
    /*1. 矩阵变量语法:
        请求路径: <a href="/cars/sell;low=34;brand=byd,bm,dz" >矩阵变量请求 1</a>
    * 2. springboot默认禁用了矩阵变量的功能.
        需要手动开启, 其原理是 使用 UrlPathHelper 进行路径解析
         removeSemicolonContent（移除分号内容）用来控制矩阵变量是否开启的.
      3. 矩阵变量必须有url路径变量才能被解析
    * */
    @GetMapping("/cars/{path}")
    public Map carsSell1(@MatrixVariable("low") Integer low,
                      @MatrixVariable("brand") List<String> brands,
                          @PathVariable("path") String path){
        System.out.println("low : "+low);
        brands.forEach(brand -> System.out.println("brand : "+brand));

        HashMap<String, Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brands);
        map.put("path",path);

        return map;
    }

    // 请求路径: /boss/1;age=20/2;age=10
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age",pathVar = "empId") Integer empAge){
        System.out.println("bossAge : "+bossAge);
        System.out.println("empAge :" + empAge);
        Map<String,Object> map = new HashMap<>();

        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        return map;

    }





}
