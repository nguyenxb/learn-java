
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--
    JSP 表达式
    作用：用来输出数据 输出到客户端
    语法：<%= 变量或表达式%>
--%>
    <%= new java.util.Date()%>

    <hr/>

<%--
    JSP 脚本片段
--%>
    <%
        int sum = 0;
        for (int i = 0; i<=100;i++){
            sum += i;
        }
        out.print("<h1>sum="+sum+"</h1>");
    %>
    <hr>
<%--在java代码直接嵌入HTML--%>
    <%
        int x = 10;
       out.print(x);
    %>
    <p>这是一个JSP文档</p>
    <%
        int y = 5;
        out.print(y);
    %>

    <hr>

<%--在Java代码中嵌入HTML元素，将java代码分割--%>
    <%
        for (int i = 0; i < 3; i++) {
    %>
    <h2>Hello,world <%= i %></h2>
    <%
        }
    %>
    <hr>

<%--
   JSP声明 将变量，方法定义到类中
--%>
<%!
    static {
        System.out.println("Loading Servlet!");
    }
    private int globalVar = 0;

    public void ruasib(){
        System.out.println("进入了方法ruasib");
    }
%>

</body>
</html>
