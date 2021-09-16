<%--
  Created by IntelliJ IDEA.
  User: nguyen
  Date: 2021/7/18
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/servlet/login" method="post">
        <h1>登录</h1>
        <label>
            <input type="text" name="username">
            <input type="submit" value="登录">
        </label>
    </form>
</body>
</html>
