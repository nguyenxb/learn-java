

#  javaweb



### 1、基本概念

web 开发：

- ​	web,网页，例如 : www.baidu.com

- 静态web
  - html,css
  - 提供给所有人看的数据，且始终不会变换

- 动态web
  - ​	淘宝，等几乎所有网站
  - 提供给所有人看的数据始终会发生变化的，每个人在不同的时间不同的地点看到的信息是不同的
  - 技术栈：Servlet/JSP,ASP,PHP

在Java中动态web资源开发的技术都称为javaweb;

#### 1.2、web应用程序

​	web应用程序：可以提供浏览器访问的程序；

- html文件，a.html、b.html等多个资源，这些web资源可以被外界访问，对外界提供服务；

- 我们能访问到的任何一个页面或者资源都存在于世界上的某一个计算机中

- URL:统一资源定位符

- 这个统一的web资源会被放在同一个文件夹下，web应用程序-->Tomcat服务器

- 一个web应用由多部分组成（静态web,动态web）

  - html,css,js
  - jsp,servlet
  - java程序
  - jar包
  - 配置文件（Properties）

  web应用程序编写完毕后，如果想要提供给外界访问，需要一个服务器来统一管理

#### 1.3 静态web

- ​	*.html,  *.htm,这些都是网页的后缀，如果服务器上一直存在这些东西，我们就能直接进行读取,

  ![](D:\typora\java\day01\新建文件夹\1.jpg)

- 静态web存在的缺点
  - Web页面无法动态更新，所有用户看到的都是同一个页面
    - 轮播图:点击特效:伪动态
    - javascript[在实际开发中使用的最多]
    - VBscript
  - 它无法和数据库交互（数据无法持久化，用户无法交互）

#### 1.4、动态web

页面会动态：“web的页面展示的效果每个人都不同"；

![](D:\typora\java\day01\新建文件夹\2.jpg)

缺点

- ​	如果加入服务器的动态web资源出现了错误，那么需要重新编写后台程序，重新发布：
  - ​	如停机维护

优点：

- web页面可以动态更新，所有的用户看到的界面都不是同一个页面

- 它可以与数据库交互

  ![](D:\typora\java\day01\新建文件夹\3.jpg)



### 2.1、web服务器

基于ASP,JSP,php

JSP/Servlet:

B/S：浏览器和服务器

C/S：客户端和服务器

- sun公司主推的B/S架构
- 基于Java语言的（所有的大公司或者一些开源组件都是java写的）
- 可以承载三高问题的影响
- 语法像ASP,ASP--> JSP,加强市场强度；



#### 2.2 web 服务器

服务器是一种被动的操作，用来处理用户的一些请求和给用户一些响应信息；

##### IIS

微软的：ASP,windows中自带



### 3.1 Tomcat:（摘自百度百科）

Tomcat 服务器是一个免费的开放源代码的Web 应用服务器，属于轻量级应用[服务器](https://baike.baidu.com/item/服务器)，在中小型系统和并发访问用户不是很多的场合下被普遍使用，是开发和调试JSP 程序的首选。对于一个初学者来说，可以这样认为，当在一台机器上配置好Apache 服务器，可利用它响应[HTML](https://baike.baidu.com/item/HTML)（[标准通用标记语言](https://baike.baidu.com/item/标准通用标记语言/6805073)下的一个应用）页面的访问请求。实际上Tomcat是Apache 服务器的扩展，但运行时它是独立运行的，所以当你运行tomcat 时，它实际上作为一个与Apache 独立的进程单独运行的。

诀窍是，当配置正确时，Apache 为HTML页面服务，而Tomcat 实际上运行JSP 页面和Servlet。另外，Tomcat和[IIS](https://baike.baidu.com/item/IIS)等Web服务器一样，具有处理HTML页面的功能，另外它还是一个Servlet和JSP容器，独立的Servlet容器是Tomcat的默认模式。



tomcat的默认端口号：8080

mysql的默认端口：3306

http 的默认端口：80

https默认端口：443

```xml
 <!-- 1 可以在路径：C:\Windows\System32\drivers\etc\hosts文件下配置本机域名 -->


<!--在E:\Dev_Language\apache-tomcat-8.0.20\conf\server.xml 文件下配置tomcat的端口号和主机名称。-->
    <Connector executor="tomcatThreadPool"
               port="8080" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" />
<!-- 默认的主机名：localhost -> 127.0.0.1 -->
<!--  默认网站应用存放的位置为：wabapps 
	
      <Host name="localhost"  appBase="webapps"
            unpackWARs="true" autoDeploy="true">

```

高难度面试题：

​	请你谈谈网站时如何进行访问的？

​	1、输入一个域名：回车

​	2、检查本机的C:\Windows\System32\drivers\hosts配置文件下有没有这个域名映射：

​		1.有：直接返回对应的ip地址，这个地址中，有我们需要访问的web程序，可以直接访问

​		2.没有去DNS服务器找，找到的话就返回，找不到就返回找不到

![](D:\typora\java\day01\新建文件夹\4.jpg)



4.可以配置环境变量（可选项）

#### 3.4、发布一个web网站

​	将自己写的网站，放到服务器（Tomcat）中指定的web应用文件夹下（webapps）下，就可以访问了，网站的基本结构：

```java
-- webapps: Tomcat服务器web目录
	-ROOT
	-ruasibstudy:网站目录名
	-WEB-INF
		-classes : java程序
		-lib:web应用所依赖的jar包
		-web.xml
	-index.html 默认的首页
	-static
		-css
			-style.css
		-js
		-img
	- .....
```

HTTP协议：面试

Maven :构建工具

- maven安装包

Servlet入门

- Helloword

- Servlet配置
- 原理

### 4、HTTP

#### 4.1 什么是https?

超文本传输协议（Hypertext Transfer Protocol，HTTP）是一个简单的请求-响应协议，它通常运行在[TCP](https://baike.baidu.com/item/TCP/33012)之上。它指定了客户端可能发送给服务器什么样的消息以及得到什么样的响应。请求和响应消息的头以[ASCII](https://baike.baidu.com/item/ASCII/309296)形式给出；而消息内容则具有一个类似[MIME](https://baike.baidu.com/item/MIME/2900607)的格式。这个简单模型是早期[Web](https://baike.baidu.com/item/Web/150564)成功的有功之臣，因为它使开发和部署非常地直截了当。

- 文本：html，字符串，~...
- 超文本：图片，音乐，视频，定位，地图...
- 端口：80

https: 安全的超文本传输协议

- 端口：443

#### 4.2 、 两个时代

- http1.0
  - HTTP/1.0：客户端可以与web服务器连接后，只能获得一个web资源，断开连接

- http2.0
  - ​	HTTP/1.1:客户端可以与web服务器连接后，可以获得多个web资源

#### 4.3、 Http请求

- 客户端-- 发请求（Request） --> 服务器

百度：

```java
Request URL: https://www.baidu.com/    请求地址
Request Method: GET 	请求方法：get方法、post方法
Status Code: 200 OK		状态码：200
Remote Address: 14.215.177.38:443 百度的地址 + 端口


Cache-Control: private	缓存控制
Connection: keep-alive	连接方式：保持连接
Content-Encoding: gzip	编码
Content-Type: text/html;charset=utf-8	文件类型：html，以及文件编码:utf-8
Date: Mon, 28 Jun 2021 01:43:29 GMT	
Expires: Mon, 28 Jun 2021 01:43:28 GMT
Server: BWS/1.1
Set-Cookie: BDSVRTM=386; path=/
Set-Cookie: BD_HOME=1; path=/
Set-Cookie: H_PS_PSSID=33801_33966_31254_34113_33607_34134_34119; path=/; domain=.baidu.com
Strict-Transport-Security: max-age=172800
Traceid: 1624844609018818305012084217433091881680
Transfer-Encoding: chunked
X-Ua-Compatible: IE=Edge,chrome=1
```

#### 

#### 1、请求行

- 请求行中的请求方式：GET
- 请求方式：**Get,Post**,HEAD,DELETE,put,tract...
  - get :请求能够携带的方式较少，大小有限制，会在浏览器的URL地址栏显示数据内容，不安全，但高效
  - post : 请求能够携带的参数没有限制，大小没有限制，不会再浏览器的URL地址显示数据内容，安全，但不高效。

#### 2、消息头：

```java
Accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9   告诉浏览器它所支持的数据类型
Accept-Encoding: gzip, deflate, br 支持哪种编码格式 ：GBK、utf-8、GB2312、iso8859-1
Accept-Language: zh-CN,zh;q=0.9 告诉六拉起。他的语言环境
Cache-Control: max-age=0	缓存控制
Connection: keep-alive	告诉浏览器，请求完成的是断开连接和保持连接
HOST : 主机ip地址以及端口
```

#### 	4.4、Http响应

- 服务器--响应---客户端

  百度：

  ```
  Access-Control-Allow-Credentials: true
  Access-Control-Allow-Methods: GET, POST, OPTIONS
  Access-Control-Allow-Origin: *
  Cache-Control: no-cache
  Connection: keep-alive
  Content-Length: 0
  Content-Type: image/gif
  Date: Mon, 28 Jun 2021 01:43:31 GMT
  Pragma: no-cache
  Server: nginx/1.8.0
  Set-Cookie: BAIDUID_BFESS=C23FC53DC981E34B8842BF60593436D4:FG=1; Path=/; Domain=baidu.com; Expires=Tue, 28 Jun 2022 01:43:31 GMT; Max-Age=31536000; Secure; SameSite=None
  Set-Cookie: BDUSS_BFESS=k5GNVdXeXBCSjl3NUE0Z3hvSTVCT3NEUk5TakhjYXhLS3dQc2dNQWIyOTIwTTVnSVFBQUFBJCQAAAAAAAAAAAEAAABpXVFFXzEydgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHZDp2B2Q6dgY; Path=/; Domain=baidu.com; Expires=Thu, 26 Jun 2031 01:43:31 GMT; Max-Age=315360000; HttpOnly; Secure; SameSite=None
  Tracecode: 26119272462803688714062809
  ```

  #### 1.响应体

  ```
  Accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9   告诉浏览器它所支持的数据类型
  Accept-Encoding: gzip, deflate, br 支持哪种编码格式 ：GBK、utf-8、GB2312、iso8859-1
  Accept-Language: zh-CN,zh;q=0.9 告诉六拉起。他的语言环境
  Cache-Control: max-age=0	缓存控制
  Connection: keep-alive	告诉浏览器，请求完成的是断开连接和保持连接
  HOST : 主机ip地址以及端口
  Refresh:  告诉客户端，多久刷新一次；
  Location:让网页重新定位；
  ```

  #### 2、 响应状态码

  200 ： 请求响应成功

  3xx ：请求重定向

  - 重新到服务器给的新位置去

  4xx ：找不 到资源 404

  - 资源不存在

  5xx : 服务器代码错误 500, 502 ： 网关错误

  

  #### 常见面试题：

  当你的浏览器中地址输入地址并回车的一瞬间到页面能够显示回来，经历了什么？

  

### 5、Maven

#### 5.1 为什么要学这个技术？

1、再javaweb开发中，需要使用大量的jar包，我们手动去导入；

2、如何能够让一个东西自动帮我导入和配置这个jar包



#### 5.2 下载安装

![](D:\typora\java\day01\新建文件夹\5.jpg)



下载解压即可；

提示：电脑上的所有环境都放在一个文件夹下，方便管理



#### 5.3 配置环境变量

再我们的系统环境变量下，配置如下：

- M2_HOME    maven目录下的bin目录
- MAVEN_HOME   maveb的目录
- 在系统的path中配置： %MAVEN_HOME%\bin

![](D:\typora\java\day01\新建文件夹\6.jpg)

 测试maven是否安装成功，保证必须配置完毕！

#### 5.4 阿里云镜像

- 镜像：mirrors

  ```xml
   <mirror>
       <id>nexus-aliyun</id>
       <mirrorOf>*,!jeecg,!jeecg-snapshots</mirrorOf>
       <name>Nexus aliyun</name> 			     			    			 <url>http://maven.aliyun.com/nexus/content/groups/public</url> 
    </mirror>
  ```

#### 5.5 本地仓库：

在本地的仓库，远程仓库：

​	**建立本地仓库**：

```xml
<localRepository>E:\Dev_Language\JAVA\maven\apache-maven-3.6.2\maven-repo</localRepository>	
```

#### 5.6、在IDEA使用Maven

1、启动IDEA

2、创建一个MavenWeb项目

![](D:\typora\java\day01\新建文件夹\8.jpg)

![](D:\typora\java\day01\新建文件夹\9.jpg)

![](D:\typora\java\day01\新建文件夹\10.jpg)

**3 然后等待项目初始化完成**

![](D:\typora\java\day01\新建文件夹\11.jpg)

**4 查看仓库文件**

![](D:\typora\java\day01\新建文件夹\12.jpg)

**5 idea中的maven设置**

![](D:\typora\java\day01\新建文件夹\13.jpg)

![](D:\typora\java\day01\新建文件夹\14.jpg)

在这里maven在idea中配置的maven就ok了

#### 5.7 Maven创建一个普通的maven项目

![](D:\typora\java\day01\新建文件夹\15.jpg)

![](D:\typora\java\day01\新建文件夹\16.jpg)

**一个干净的maven**

![](D:\typora\java\day01\新建文件夹\17.jpg)

**一个带模板的maven**

![](D:\typora\java\day01\新建文件夹\18.jpg)

#### 5.8 设置文件目录结构：

![](D:\typora\java\day01\新建文件夹\19.jpg)

![](D:\typora\java\day01\新建文件夹\20.jpg)

![](D:\typora\java\day01\新建文件夹\21.jpg)

#### 5.9 在idea中配置tomcat

![](D:\typora\java\day01\新建文件夹\22.jpg)

![](D:\typora\java\day01\新建文件夹\23.jpg)

![](D:\typora\java\day01\新建文件夹\24.jpg)

**解决警告信息：**

必须要解决这个问题：为什么会有这个问题？因为我们访问一个网站需要指定一个文件夹名字

![](D:\typora\java\day01\新建文件夹\25.jpg)

![](D:\typora\java\day01\新建文件夹\26.jpg)

![](D:\typora\java\day01\新建文件夹\27.jpg)

![](D:\typora\java\day01\新建文件夹\28.jpg)

![](D:\typora\java\day01\新建文件夹\29.jpg)

#### 5.10 pom文件

pom.xml 是maven的核心配置文件。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!--maven的版本和头文件-->
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
<!--这里就是我们刚刚配置的GAV 即 groupId 组id，artifactId 项目名称 ，version 版本-->
  <groupId>com.ruasib</groupId>
  <artifactId>javaweb-01-maven</artifactId>
  <version>1.0-SNAPSHOT</version>
<!--  项目的打包方式
  jar:java应用
  war:javaWeb应用
-->
  <packaging>war</packaging>
<!-- 项目名称 -->
  <name>javaweb-01-maven Maven Webapp</name>
  <!-- FIXME change it to the project's website -->
  <url>http://www.example.com</url>
<!-- 配置 -->
  <properties>
<!--    项目的默认构建编码-->
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
<!--    编码版本-->
    <maven.compiler.source>1.7</maven.compiler.source>
    <maven.compiler.target>1.7</maven.compiler.target>
  </properties>
<!--项目依赖-->
  <dependencies>
    <dependency>
<!--      具体依赖的jar包配置文件-->
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
<!--项目构建的用的东西-->
  <build>
    <finalName>javaweb-01-maven</finalName>
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
      <plugins>
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.1.0</version>
        </plugin>
        <!-- see http://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_war_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.22.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-war-plugin</artifactId>
          <version>3.2.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
</project>

```

#### 5.11 Maven存在的资源导出问题

由于maven他的约定大于配置，我们可能遇到我们写的配置文件，无法被导出或者生效的问题

![](D:\typora\java\day01\新建文件夹\30.jpg)

解决办法：

```xml
<!-- 将下列代码放入pom.xml文件中-->
<!--    在build中配置resources,来防止我们资源导出失败的问题-->
 <!--    在build中配置resources,来防止我们资源导出失败的问题-->
    <build>
        <resources>
            <resource>
                <!--  在src/main/resources 目录下可以包含properties、xml文件-->
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>false</filtering>
            </resource>
            <resource>
                <!--                在src/main/java 目录下可以包含properties、xml文件-->
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <!--                关闭自动过滤-->
                <filtering>false</filtering>
            </resource>
        </resources>
    </build>
```

#### 5.12 idea操作

![](D:\typora\java\day01\新建文件夹\31.jpg)

![32](D:\typora\java\day01\新建文件夹\32.jpg)



#### 5.13 Maven 仓库的使用

https://mvnrepository.com/

![](D:\typora\java\day01\新建文件夹\33.jpg)

![](D:\typora\java\day01\新建文件夹\34.jpg)

![](D:\typora\java\day01\新建文件夹\35.jpg)

![](D:\typora\java\day01\新建文件夹\36.jpg)

![37](D:\typora\java\day01\新建文件夹\37.jpg)

Java Servlet API

```xml

<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>3.1.0</version>
    <scope>provided</scope>
</dependency>
```



### 6、Servlet

常见的HTTP状态码：

- 200 - 请求成功
- 301 - 资源（网页等）被永久转移到其它URL
- 404 - 请求的资源（网页等）不存在
- 500 - 内部服务器错误

#### HTTP content-type [资料来源：菜鸟教程](https://www.runoob.com/http/http-content-type.html)

Content-Type（内容类型），一般是指网页中存在的 Content-Type，用于定义网络文件的类型和网页的编码，决定浏览器将以什么形式、什么编码读取这个文件，这就是经常看到一些 PHP 网页点击的结果却是下载一个文件或一张图片的原因。

Content-Type 标头告诉客户端实际返回的内容的内容类型。

语法格式：

```
Content-Type: text/html; charset=utf-8
Content-Type: multipart/form-data; boundary=something
```

##### 常见的媒体格式类型如下：

- text/html ： HTML格式
- text/plain ：纯文本格式
- text/xml ： XML格式
- image/gif ：gif图片格式
- image/jpeg ：jpg图片格式
- image/png：png图片格式

##### 以application开头的媒体格式类型：

- application/xhtml+xml ：XHTML格式
- application/xml： XML数据格式
- application/atom+xml ：Atom XML聚合格式
- application/json： JSON数据格式
- application/pdf：pdf格式
- application/msword ： Word文档格式
- application/octet-stream ： 二进制流数据（如常见的文件下载）
- application/x-www-form-urlencoded ： <form encType="">中默认的encType，form表单数据被编码为key/value格式发送到服务器（表单默认的提交数据的格式）

另外一种常见的媒体格式是上传文件之时使用的：

- multipart/form-data ： 需要在表单中进行文件上传时，就需要使用该格式

  

#### 6.1、Servlet简介

- Servlet就是sun公司开发动态web的一门技术

- Sun在这些API中提供一个接口叫做Servlet，如果你想开发Servlet程序，只需要完成两个步骤：
  - 编写一个类，实现Servlet接口
  - 把开发好的java类部署到web服务器中。

实现了Servlet接口的java程序叫做，Servlet

#### 6.2、HelloServlet

Servlet在sun公司有两个默认的实现类：HttpServelt,GenericServlet

- 构建一个普通的maven项目，删掉除了配置文件外的所有东西，即删除src目录下的所有文件，以后学习就在这个项目中建立Moudel;这个空的项目就是maven的主工程；

- 关于maven父子工程的理解：

父工程的pom.xml文件中，有以下代码，而其中的，servlet-01就是其子工程

```xml
 <modules>
        <module>servlet-01</module>
 </modules>	
```

其中父项目的java子项目可以直接使用

- Maven环境优化
  - 修改web.xml为最新
  - 将maven的结构搭建完整

- 编写一个Servlet程序
  - 编写一个普通类
  - 实现Servlet接口,这里直接基础

```java
package com.ruasib.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.print("hello,servlet");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

```

- 编写Servlet的映射

为什么需要映射：我们写的是java程序，但是要通过浏览器访问，而浏览器需要连接web服务器，所以我们需要在web服务中注册我们写的Servlet，还需要给他一个浏览器能访问的路径；

```xml
<!DOCTYPE web-app PUBLIC
 "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
 "http://java.sun.com/dtd/web-app_2_3.dtd" >
<web-app>
  <display-name>Archetype Created Web Application</display-name>
  <!--  注册Servlet-->
  <servlet>
    <servlet-name>hello</servlet-name>
    <servlet-class>com.ruasib.servlet.HelloServlet</servlet-class>
  </servlet>
<!--  Servlet的请求路径-->
  <servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>\hello</url-pattern>
  </servlet-mapping>
  
</web-app>

```

- 配置Tomcat

  注意：配置项目发布的路径就可以了

![](D:\typora\java\day01\新建文件夹\38.jpg)

- 启动测试，ok

![](D:\typora\java\day01\新建文件夹\39.jpg)

![](D:\typora\java\day01\新建文件夹\42.jpg)

![](D:\typora\java\day01\新建文件夹\43.jpg)

![](D:\typora\java\day01\新建文件夹\40.jpg)

![](D:\typora\java\day01\新建文件夹\41.jpg)



#### 6.3、Servlet原理

Servlet是由web服务器调用，web服务器在收到浏览器请求后会：

![](D:\typora\java\day01\新建文件夹\44.jpg)

#### 6.4、Mapping 问题

1. 一个Servlet可以指定一个映射路径：

   ```xml
   <web-app>
     <display-name>Archetype Created Web Application</display-name>
       
     <servlet>
       <servlet-name>servlet-01</servlet-name>
       <servlet-class>HelloServlet</servlet-class>
     </servlet>
   <!--  浏览器访问方式：localhost:8080/s1/haha -->
     <servlet-mapping>
       <servlet-name>servlet-01</servlet-name>
       <url-pattern>/haha</url-pattern>
     </servlet-mapping>
   </web-app>
   ```

2. 一个Servlet可以指定多个映射路径

   ```xml
   <web-app>
     <display-name>Archetype Created Web Application</display-name>
       
     <servlet>
       <servlet-name>servlet-01</servlet-name>
       <servlet-class>HelloServlet</servlet-class>
     </servlet>
   <!--  浏览器访问方式：localhost:8080/s1/haha -->
     <servlet-mapping>
       <servlet-name>servlet-01</servlet-name>
       <url-pattern>/haha</url-pattern>
     </servlet-mapping>
   <!--  浏览器访问方式：localhost:8080/s1/haha1 -->
     <servlet-mapping>
       <servlet-name>servlet-01</servlet-name>
       <url-pattern>/haha1</url-pattern>
     </servlet-mapping>
   <!--  浏览器访问方式：localhost:8080/s1/haha2 -->
     <servlet-mapping>
       <servlet-name>servlet-01</servlet-name>
       <url-pattern>/haha2</url-pattern>
     </servlet-mapping>
   </web-app>
   ```

   

3. 一个Servlet可以指定通用映射路径

   ```xml
   <web-app>
     <display-name>Archetype Created Web Application</display-name>
     <servlet>
       <servlet-name>servlet-01</servlet-name>
       <servlet-class>HelloServlet</servlet-class>
     </servlet>
   <!--  浏览器访问方式：localhost:8080/s1/haha/...  
   	意思：在/haha下的任意 路径下都会走这个Servlet
   -->
     <servlet-mapping>
       <servlet-name>servlet-01</servlet-name>
       <url-pattern>/haha/*</url-pattern>
     </servlet-mapping>
   </web-app>
   ```

4. 默认请求路径

   ```xml
   <web-app>
     <display-name>Archetype Created Web Application</display-name>
     <servlet>
       <servlet-name>servlet-01</servlet-name>
       <servlet-class>HelloServlet</servlet-class>
     </servlet>
   <!--  浏览器访问方式：localhost:8080/s1/...
   	意思：在任意路径下都会走这个Servlet
   -->
     <servlet-mapping>
       <servlet-name>servlet-01</servlet-name>
       <url-pattern>/*</url-pattern>
     </servlet-mapping>
   </web-app>
   ```

5. 指定以下后缀或者前缀等等..

   ```xml
   <web-app>
     <display-name>Archetype Created Web Application</display-name>
     <servlet>
       <servlet-name>servlet-01</servlet-name>
       <servlet-class>HelloServlet</servlet-class>
     </servlet>
   
     <servlet-mapping>
       <servlet-name>servlet-01</servlet-name>
         <!--会报错:  .*前面不能加项目映射的路径-->
       <url-pattern>/haha/*.ruasib</url-pattern>
     </servlet-mapping>
       
     <servlet-mapping>
       <servlet-name>servlet-01</servlet-name>
         <!--会报错:  .*前面不能加项目映射的路径-->
       <url-pattern>/haha/*.ruasib</url-pattern>
     </servlet-mapping>
       
    <servlet-mapping>
       <servlet-name>servlet-01</servlet-name>
         <!--任何以ruasib为后缀的请求路径都执行该Servlet-->
       <url-pattern>*.ruasib</url-pattern>
     </servlet-mapping>
       
   </web-app>
   
   ```

6. 指定了固有的映射路径优先级最高，如果找不到就会走默认的处理请求；

   ```xml
   <!-- 404:错误请求-->
   <servlet>
       <servlet-name>servlet-01</servlet-name>
       <servlet-class>HelloServlet</servlet-class>
     </servlet>
   
     <servlet-mapping>
       <servlet-name>servlet-01</servlet-name>
       <url-pattern>/*</url-pattern>
     </servlet-mapping>
   ```

#### 6.5、ServletContext

web容器在启动的时候，他会为每个web程序创建一个对应的ServletContext，它代表了当前的web应用；



##### 共享数据

在这个Servlet中保存的数据，可以在另外一个servlet中拿到

```java
// 将数据写入ServletContext
package com.ruasib.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        this.getInitParameter(String name); 初始化参数
//        this.getServletConfig()       Servlet配置
//        this.getServletContext();     Servlet上下文对象

        ServletContext servletContext = this.getServletContext();
        String username = "ruasib"; // 数据
        // 将一个数据保存在ServletContext中，键为username,值为username（变量）
        servletContext.setAttribute("username",username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

```

```java
// 从ServletContext中获取数据
package com.ruasib.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        // 将数据从contetx中按照键“username”来获取到对应的值（数据）
        String username = (String)context.getAttribute("username");

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print("名字="+username);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

```

```xml
<!--配置的web.xml文件-->
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="3.0" xmlns="http://java.sun.com/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
	http://java.sun.com/xml/ns/javaee/web-app_4_0.xsd">
  <display-name>Archetype Created Web Application</display-name>
  <servlet>
    <servlet-name>hello</servlet-name>
    <servlet-class>com.ruasib.servlet.HelloServlet</servlet-class>
  </servlet>

  <servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/hello</url-pattern>
  </servlet-mapping>
  
  <servlet>
    <servlet-name>getc</servlet-name>
    <servlet-class>com.ruasib.servlet.GetServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>getc</servlet-name>
    <url-pattern>/getc</url-pattern>
  </servlet-mapping>

</web-app>



```

运行结果：

![](D:\typora\java\day01\新建文件夹\45.jpg)

![](D:\typora\java\day01\新建文件夹\46.jpg)



##### 获取初始化参数

```java
// 获取在web.xml文件中的<context-param>标签的名为url的参数的数据
package com.ruasib.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 读取在web.xml文件中得到的xml参数
        ServletContext context = this.getServletContext();
        String url = context.getInitParameter("url");
        resp.getWriter().print(url);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

```

```xml
<!--配置的web.xml文件-->
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="3.0" xmlns="http://java.sun.com/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
	http://java.sun.com/xml/ns/javaee/web-app_4_0.xsd">
  <display-name>Archetype Created Web Application</display-name>
<!--  配置context的初始化参数-->
  <context-param>
    <param-name>url</param-name>
    <param-value>jdbc:mysql://localhost:3306/mybatis</param-value>
  </context-param>

  <servlet>
    <servlet-name>gp</servlet-name>
    <servlet-class>com.ruasib.servlet.ServletDemo3</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>gp</servlet-name>
    <url-pattern>/gp</url-pattern>
  </servlet-mapping>

</web-app>

```

![](D:\typora\java\day01\新建文件夹\47.jpg)



##### 请求转发

```java
// 转发类
package com.ruasib.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 请求转发
        ServletContext context = this.getServletContext();
        System.out.println("进入了ServletDemo04");
        // 获取转发的请求路径
        RequestDispatcher requestDispatcher = context.getRequestDispatcher("/gp");
        // 调用forward实现请求转发
        requestDispatcher.forward(req,resp);

//        第二种方式：实现请求转发
//        context.getRequestDispatcher("/gp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

```

```java
// 转发目的地
package com.ruasib.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print("进入了ServletDemo03");
        System.out.println("进入了ServletDemo03");
        // 读取在web.xml文件中得到的xml参数
        ServletContext context = this.getServletContext();
        String url = context.getInitParameter("url");
        resp.getWriter().print(url);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

```

```xml
<!--配置的web.xml文件-->
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="3.0" xmlns="http://java.sun.com/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
	http://java.sun.com/xml/ns/javaee/web-app_4_0.xsd">
  <display-name>Archetype Created Web Application</display-name>
<!--  ServletDemo3-->
<!--  配置context的初始化参数-->
  <context-param>
    <param-name>url</param-name>
    <param-value>jdbc:mysql://localhost:3306/mybatis</param-value>
  </context-param>

  <servlet>
    <servlet-name>gp</servlet-name>
    <servlet-class>com.ruasib.servlet.ServletDemo3</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>gp</servlet-name>
    <url-pattern>/gp</url-pattern>
  </servlet-mapping>

  <!--  ServletDemo4-->
  <servlet>
    <servlet-name>sd4</servlet-name>
    <servlet-class>com.ruasib.servlet.ServletDemo4</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>sd4</servlet-name>
    <url-pattern>/sd4</url-pattern>
  </servlet-mapping>

</web-app>

```

运行结果：

![](D:\typora\java\day01\新建文件夹\48.jpg)

![](D:\typora\java\day01\新建文件夹\49.jpg)



##### 读取资源文件

Properties文件

- 在Java目录下新建aa.properties
- 在resources目录下新建db.properties

发现：在没有解决Maven存在的资源导出问题时后，会将java目录下的文件无法被导出到target目录下，Maven存在的资源导出问题解决方案5.11章节中

当解决了Maven存在的资源导出问题后，重新生成文件，发现：两个目录下的properties文件都被打包到了同一个路径下：classes，我们俗称这个路径为classpath;

- 思路：需要一个文件流从

```java

package com.ruasib.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class propertiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  `/`代表当前web应用
        // 读取目录 target/servlet-02-1.0-SNAPSHOT//WEB-INF/classes/db.properties 的文件
//        InputStream inputStream = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");

        // 读取目录 target/servlet-02-1.0-SNAPSHOT//WEB-INF/classes/WEB-INF/classes/com/ruasib/servlet/aa.properties 的文件
        InputStream inputStream = this.getServletContext().getResourceAsStream(
                "/WEB-INF/classes/com/ruasib/servlet/aa.properties");
        Properties prop = new Properties();
        prop.load(inputStream);
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        resp.getWriter().print(username+":"+password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

```

```xml
<!--配置的web.xml文件-->
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="3.0" xmlns="http://java.sun.com/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
	http://java.sun.com/xml/ns/javaee/web-app_4_0.xsd">
  <display-name>Archetype Created Web Application</display-name>

<!--propertiesServlet-->
  <servlet>
    <servlet-name>sd5</servlet-name>
    <servlet-class>com.ruasib.servlet.propertiesServlet</servlet-class>
  </servlet>
  
  <servlet-mapping>
    <servlet-name>sd5</servlet-name>
    <url-pattern>/sd5</url-pattern>
  </servlet-mapping>

</web-app>

```

```properties
# db.properties
username=ruasib
password=123456
```

```properties
# aa.properties
username=hasib
password=xcvbnm
```



文件结构：

![](D:\typora\java\day01\新建文件夹\52.jpg)

运行结果：

![](D:\typora\java\day01\新建文件夹\50.jpg)

![51](D:\typora\java\day01\新建文件夹\51.jpg)



#### 6.6、HttpServletResponse

web服务器接收到客户端的http请求，针对这个请求，分别创建一个代表HttpServletRequest对象，代表响应的一个HttpServletResponse；

- 如果要获取客户端请求过来的参数：找HttpServletRequest
- 如果要给客户端响应一些信息：找HttpServletResponse

##### 1、简单分类

###### 负责向浏览器发送数据的方法：

```java
    ServletOutputStream getOutputStream() throws IOException;

    PrintWriter getWriter() throws IOException;
```

###### 负责向浏览器发送响应头的方法：

```java
 	void setCharacterEncoding(String var1);

    void setContentLength(int var1);

    void setContentType(String var1);

	void sendRedirect(String var1) throws IOException;

    void setDateHeader(String var1, long var2);

    void addDateHeader(String var1, long var2);

    void setHeader(String var1, String var2);

    void addHeader(String var1, String var2);

    void setIntHeader(String var1, int var2);

    void addIntHeader(String var1, int var2);

    void setStatus(int var1);

```

###### 响应的状态码：

```java
 	int SC_CONTINUE = 100;
    int SC_SWITCHING_PROTOCOLS = 101;
    int SC_OK = 200;
    int SC_CREATED = 201;
    int SC_ACCEPTED = 202;
    int SC_NON_AUTHORITATIVE_INFORMATION = 203;
    int SC_NO_CONTENT = 204;
    int SC_RESET_CONTENT = 205;
    int SC_PARTIAL_CONTENT = 206;
    int SC_MULTIPLE_CHOICES = 300;
    int SC_MOVED_PERMANENTLY = 301;
    int SC_MOVED_TEMPORARILY = 302;
    int SC_FOUND = 302;
    int SC_SEE_OTHER = 303;
    int SC_NOT_MODIFIED = 304;
    int SC_USE_PROXY = 305;
    int SC_TEMPORARY_REDIRECT = 307;
    int SC_BAD_REQUEST = 400;
    int SC_UNAUTHORIZED = 401;
    int SC_PAYMENT_REQUIRED = 402;
    int SC_FORBIDDEN = 403;
    int SC_NOT_FOUND = 404;
    int SC_METHOD_NOT_ALLOWED = 405;
    int SC_NOT_ACCEPTABLE = 406;
    int SC_PROXY_AUTHENTICATION_REQUIRED = 407;
    int SC_REQUEST_TIMEOUT = 408;
    int SC_CONFLICT = 409;
    int SC_GONE = 410;
    int SC_LENGTH_REQUIRED = 411;
    int SC_PRECONDITION_FAILED = 412;
    int SC_REQUEST_ENTITY_TOO_LARGE = 413;
    int SC_REQUEST_URI_TOO_LONG = 414;
    int SC_UNSUPPORTED_MEDIA_TYPE = 415;
    int SC_REQUESTED_RANGE_NOT_SATISFIABLE = 416;
    int SC_EXPECTATION_FAILED = 417;
    int SC_INTERNAL_SERVER_ERROR = 500;
    int SC_NOT_IMPLEMENTED = 501;
    int SC_BAD_GATEWAY = 502;
    int SC_SERVICE_UNAVAILABLE = 503;
    int SC_GATEWAY_TIMEOUT = 504;
    int SC_HTTP_VERSION_NOT_SUPPORTED = 505;

```

###### 常见应用

1. 向浏览器输出消息

2. 下载文件

   1. 要获取下载文件的路径
   2. 下载的文件名是什么？
   3. 设置想办法让浏览器能够支持下载我们需要的东西
   4. 获取下载文件的输入流
   5. 创建缓冲区
   6. 获取OutputStream对象
   7. 将FileOutputStream流写入到buffer缓冲区，使用OutputStream将缓冲区中的数据输出到客户端

   ```java
   package com.ruasib.servlet;
   
   import javax.servlet.ServletException;
   import javax.servlet.ServletOutputStream;
   import javax.servlet.http.HttpServlet;
   import javax.servlet.http.HttpServletRequest;
   import javax.servlet.http.HttpServletResponse;
   import java.io.File;
   import java.io.FileInputStream;
   import java.io.IOException;
   import java.io.InputStream;
   import java.net.URLEncoder;
   
   public class FileDownServlet extends HttpServlet {
       @Override
       protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           //1. 获取要下载文件的路径
           String realPath = "D:\\java_workplace\\javaweb\\javaweb-servlet\\response\\" +
                           "target\\response-1.0-SNAPSHOT\\WEB-INF\\classes\\莉雅.jpg";
           System.out.println("要下载的文件路径："+realPath);
           //2. 下载的文件名是什么？
           // 最后一个 // 后的
           String fileName = realPath.substring(realPath.lastIndexOf("\\")+1);
           //3. 设置想办法让浏览器能够支持(Content-Disposition)下载我们需要的东西,使用URLEncoder.encode对中文文件名进行编码，
   
           resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));
           //4. 获取下载文件的输入流
           FileInputStream in = new FileInputStream(realPath);
           //5. 创建缓冲区
           int len = 0;
           byte[] buf = new byte[1024];
           //6. 获取OutputStream对象
           ServletOutputStream out = resp.getOutputStream();
           //7. 将FileOutputStream流写入到buffer缓冲区
           // 使用OutputStream将缓冲区中的数据输出到客户端
           while((len=in.read(buf))!=-1){
               out.write(buf,0,len);
           }
           in.close();
           out.close();
   
       }
   
       @Override
       protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          doGet(req,resp);
       }
   }
   
   
   ```

   ```xml
   <!--配置的web.xml文件-->
   <?xml version="1.0" encoding="UTF-8"?>
   <web-app version="3.0" xmlns="http://java.sun.com/xml/ns/javaee"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
   	http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd">
     <display-name>Archetype Created Web Application</display-name>
     <servlet>
       <servlet-name>down</servlet-name>
       <servlet-class>com.ruasib.servlet.FileDownServlet</servlet-class>
     </servlet>
     <servlet-mapping>
       <servlet-name>down</servlet-name>
       <url-pattern>/down</url-pattern>
     </servlet-mapping>
   </web-app>
   ```

3. 生成验证码

```java
package com.ruasib.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // 设置客户端每隔3秒自动刷新页面
        resp.setHeader("refresh","3");
        // 创建带缓冲区的图片对象,就相当于创建一个画板
        BufferedImage image = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
        // 使用笔画出图片
        Graphics2D graphics2D = (Graphics2D) image.getGraphics(); // 笔
        // 设置笔的颜色
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(0,0,80,20);
        // 给图片写数据
        graphics2D.setColor(Color.BLUE);
        graphics2D.setFont(new Font(null,Font.BOLD,20));
        graphics2D.drawString(makeNum(),0,20);

        // 将图片返回到客户端
        resp.setContentType("image/jpg");
        // 网站存在缓存 ，不让网站缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

        // 将图片写给浏览器
        boolean write = ImageIO.write(image,"jpg",resp.getOutputStream());


    }

    private String makeNum() {
        Random random = new Random();
        String num = random.nextInt(9999)+"";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4 - num.length(); i++) {
            sb.append(0);
        }
        return sb.toString()+ num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

```

```xml
<!--配置的web.xml文件-->
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="3.0" xmlns="http://java.sun.com/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
	http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd">
  <display-name>Archetype Created Web Application</display-name>

  <servlet>
    <servlet-name>img</servlet-name>
    <servlet-class>com.ruasib.servlet.ImageServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>img</servlet-name>
    <url-pattern>/img</url-pattern>
  </servlet-mapping>
</web-app>
```

运行结果：

![](D:\typora\java\day01\新建文件夹\53.jpg)



##### 2、实现重定向

```java
package com.ruasib.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//         // 实现重定向
//        resp.setHeader("Location","/res/img");
//        // 重定向状态码：302
//        resp.setStatus(302);// HttpServletResponse.SC_FOUND
           resp.sendRedirect("/res/img"); // 重定向
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

```

```xml
<!--配置的web.xml文件-->
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="3.0" xmlns="http://java.sun.com/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
	http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd">
  <display-name>Archetype Created Web Application</display-name>

  <servlet>
    <servlet-name>img</servlet-name>
    <servlet-class>com.ruasib.servlet.ImageServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>img</servlet-name>
    <url-pattern>/img</url-pattern>
  </servlet-mapping>
  <servlet>
    <servlet-name>rs</servlet-name>
    <servlet-class>com.ruasib.servlet.ImageServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>rs</servlet-name>
    <url-pattern>/rs</url-pattern>
  </servlet-mapping>

</web-app>
```

面试题：请你聊聊重定向和转发的区别？

相同点：

- 页面都会跳转

不同点：

- 请求转发时，url不会发生变化
- 重定向时，url地址栏会发生变化

转发和重定向
转发特点：
1.一次请求
2.地址不变
3.一个请求只有一个request，A和B可以通过他共享数据
4.只能转发到项目内部的资源

重定向的特点

1.二次请求
2.地址不变
3.二个请求有两个request，A和B无法通过他共享数据
4.可以重定向到项目外部的资源

![](D:\typora\java\day01\新建文件夹\54.jpg)



###### test

小测试

```java
package com.ruasib.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username+":"+password);
        // 重定向 ，一定要主要路径，否则404 
        resp.sendRedirect("/res/success.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

```

```xml
<!--配置的web.xml文件-->
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="3.0" xmlns="http://java.sun.com/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
	http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd">
  <display-name>Archetype Created Web Application</display-name>
  <servlet>
    <servlet-name>request</servlet-name>
    <servlet-class>com.ruasib.servlet.RequestTest</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>request</servlet-name>
    <url-pattern>/login</url-pattern>
  </servlet-mapping>


</web-app>
```

```jsp
<%--index.jsp--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<%--这里提交的路径，需要寻找到项目的路径
${pageContext.request.contextPath}代表当前项目
--%>
<form action="${pageContext.request.contextPath}/login" method="get">
        用户名：<input type="text" name="username"/><br>
        密码：<input type="password" name="password"/>
        <input type="submit">
</form>
</body>
</html>

```

```jsp
<%-- success.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>success</h1>
</body>
</html>

```

运行结果：

![](D:\typora\java\day01\新建文件夹\55.jpg)

![](D:\typora\java\day01\新建文件夹\56.jpg)



#### 6.7、  HttpServletRequest

HttpServletRequest代表客户端的请求，用户通过Http协议访问服务器，Http请求中的所有信息会被封装到HttpServletRequest，通过这个HttpServletRequest的方法，获得客户端的所有信息；

##### 获取前端参数，并请求转发

```java
package com.ruasib.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobbies = req.getParameterValues("hobby");

        System.out.println("=========================");
        System.out.println(username);
        System.out.println(password);
        System.out.println(Arrays.toString(hobbies));
        System.out.println("=========================");
        //   / 表示当前web项目
        req.getRequestDispatcher("/success.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

```

```xml
<!--配置的web.xml文件-->
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="3.0" xmlns="http://java.sun.com/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
	http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd">
  <display-name>Archetype Created Web Application</display-name>

  <servlet>
    <servlet-name>LoginServlet</servlet-name>
    <servlet-class>com.ruasib.servlet.LoginServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>LoginServlet</servlet-name>
    <url-pattern>/login</url-pattern>
  </servlet-mapping>
</web-app>
```

```jsp
<%--index.jsp--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <h1>登录</h1>
    <div style="text-align: center">
        <form action="${pageContext.request.contextPath}/login" method="post">
            用户名：<label>
            <input type="text" name="username" value="">
       <br>
            密码：<input type="password" name="password" value=""><br>
            爱好：
            <input type="checkbox" name="hobby" value="女孩">女孩
            <input type="checkbox" name="hobby" value="代码">代码
            <input type="checkbox" name="hobby" value="唱歌">唱歌
            <input type="checkbox" name="hobby" value="电影">电影
        </label>
            <input type="submit">
        </form>

    </div>
</body>
</html>

```

```jsp
<%--success.jsp--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    <h1>登录成功</h1>
</body>
</html>

```

![](D:\typora\java\day01\新建文件夹\57.jpg)

![](D:\typora\java\day01\新建文件夹\58.jpg)



### 7、Cookie、Session

#### 7.1、会话（Session）

**会话**：用户打开一个浏览器，点击了很多超链接，访问多个web资源，关闭浏览器，这个过程可以称为会话。

**有状态会话**：一个客户端来访问过服务器，下次再访问，服务器会知道这个客户端城景来过，称为有状态会话

**一个网站，服务器怎么知道客户端访问过？**

1、服务端给客户端一个信件，客户端下次访问带上信件就可以了（cookie）

2、服务器登记你来过了，下次来的时候服务器来匹配客户端；（session）

#### 7.2、保存会话的两种技术

##### cookie

- 客户端技术（响应，请求）

##### session

- 服务器技术，利用这个技术，可以保存用户的会话信息，我们可以将信息或者数据放在Session中。

常见案例：网站登录后，就不需要再登录了。第二次访问直接上去了。



#### 7.3、Cookie

1. 从请求中拿到Cookie信息
2. 服务器响应给客户端cookie

```java
package com.ruasib.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

// 保存用户上一次访问的时间
public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // 服务器，告诉你，你来的时间，把这个时间封装成一个信件，你下次带来，我就知道你来了

        // 解决中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        // 获取输出流
        PrintWriter out = resp.getWriter();

        //Cookie, 服务器从客户端获取到
        Cookie[] cookies = req.getCookies();// 这里返回数组，说明Cookie可能存在多个

        // 判断Cookie是否存在
        if (cookies!=null){
            // 如果存在，则取出数组中的Cookie
            out.write("你上一次访问的时间是：");
            for (Cookie cookie:cookies
                 ) {
                if(cookie.getName().equals("lastLoginTime")){
//                    获取Cookie的值
                    long lastLoginTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastLoginTime);
                    out.write(date.toString());
                }
            }

        }else {

            out.write("这是你第一次访问本站");
        }

//        服务端给客户端响应Cookie
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+"");
        // 设置 cookie最长的存活时间 ，即有效期为以 1 天
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

```

```xml
<!--配置的web.xml文件-->
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
    <servlet>
        <servlet-name>CookieDemo1</servlet-name>
        <servlet-class>com.ruasib.servlet.CookieDemo1</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>CookieDemo1</servlet-name>
        <url-pattern>/c1</url-pattern>
    </servlet-mapping>
</web-app>
```

**cookie：一般会保存再本地用户目录下appdata;**



一个网站cookie是否存在上限？

- 一个cookie只能保存一个信息；
- 一个web站点可以给浏览器发送多个cookie,每个站点最多存放20个cookie;
- cookie大小有限制 ，4kb;
- 300个cookie为浏览器存放上限



删除Cookie:

- 不设置有效期，关闭浏览器
