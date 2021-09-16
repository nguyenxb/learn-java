<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>jspTag2.jsp</h1>
    名字：<%= (String) request.getParameter("name")%>
    年龄：<%= (String) request.getParameter("age")%>
</body>
</html>
