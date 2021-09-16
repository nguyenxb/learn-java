<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: asd
  Date: 2021/7/3
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    定义一个变量叫 socre ,设置值为 85--%>
    <c:set var="score" value="85"></c:set>

<c:choose>
    <c:when test="${score>=90}">
        你的成绩优秀
    </c:when>
    <c:when test="${score>=80}">
        你的成绩良好
    </c:when>
    <c:when test="${score>=60}">
        你的成绩一般
    </c:when>
    <c:when test="${score<60}">
        你的成绩不及格
    </c:when>
</c:choose>
</body>
</html>
