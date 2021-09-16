<%--
  Created by IntelliJ IDEA.
  User: asd
  Date: 2021/7/3
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>JspTag1.jsp</h1>
    <jsp:forward page="jsptag2.jsp">
        <jsp:param name="name" value="ruasib"/>
        <jsp:param name="age" value="20"/>
    </jsp:forward>
</body>
</html>
