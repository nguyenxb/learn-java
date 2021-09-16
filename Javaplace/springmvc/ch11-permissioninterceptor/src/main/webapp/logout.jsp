<%--
  Created by IntelliJ IDEA.
  User: nguyenxb
  Date: 2021/8/21
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注销</title>
</head>
<body>
    <h1>注销操作</h1>
    <% session.removeAttribute("username");%>
</body>
</html>
