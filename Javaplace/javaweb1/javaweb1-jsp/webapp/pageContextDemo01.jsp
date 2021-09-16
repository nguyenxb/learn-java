
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 内置对象--%>
<%
    pageContext.setAttribute("name33","asda", PageContext.SESSION_SCOPE);
    //  保存的数据中只在一个页面中有效
    pageContext.setAttribute("name1","阿迪1");
    // 保存的数据只在一次请求中有效，请求转发会携带这个数据
    request.setAttribute("name2","阿迪2");
    // 保存的数据只在一次会话中有效，从打开浏览器到关闭浏览器，
    session.setAttribute("name3","阿迪3");
    // 保存的数据在服务器中有效，从打开服务器到关闭服务器
    application.setAttribute("name4","阿迪4");
%>

<%
    pageContext.setAttribute("age1","1",PageContext.PAGE_SCOPE);
    // 等价于  pageContext.setAttribute("age1","1");

    pageContext.setAttribute("age2","2",PageContext.REQUEST_SCOPE);
    // 等价于  request.setAttribute("age2","2");

    pageContext.setAttribute("age3","3",PageContext.SESSION_SCOPE);
    // 等价于  session.setAttribute("age3","3");

    pageContext.setAttribute("age4","4",PageContext.APPLICATION_SCOPE);
    // 等价于  application.setAttribute("age4","4");
    pageContext.forward();
%>
<%--
    脚本片段中的代码，会被原封不动的生成到 xxx_jsp.java中
    要求：这里的代码必须要跟Java的语法一致
--%>
<%
    //从 pageContext取出，我们通过寻找的方式来找出其中的数据
    // 从底层到高层（作用域）：page -> request -> session -> application
    // 双亲委派机制：
    String name1 = (String) pageContext.findAttribute("name1");
    String name2 = (String) pageContext.findAttribute("name2");
    String name3 = (String) pageContext.findAttribute("name3");
    String name4 = (String) pageContext.findAttribute("name4");
    String name5 = (String) pageContext.findAttribute("name5"); // 不存在
%>
<%--
    注意：EL表达式 `  ${ 变量或者表达式} ` 等价于 ` <%= 变量或者表达式 %> `

--%>
<h1>页面一，存数据的页面</h1>
<h1>EL 表达式取出的值：</h1>
<h4>${name1}</h4>
<h4>${name2}</h4>
<h4>${name3}</h4>
<h4>${name4}</h4>
<h4 style="color: yellow">${name5}</h4>
<h4 style="color: red"><%= name5%></h4>

</body>
</html>
