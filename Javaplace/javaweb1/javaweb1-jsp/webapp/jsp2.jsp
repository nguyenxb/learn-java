<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--定义发生错误页面后的跳转目标--%>
<%@page errorPage="error/500.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        int i = 1/0;
    %>
</body>
</html>
