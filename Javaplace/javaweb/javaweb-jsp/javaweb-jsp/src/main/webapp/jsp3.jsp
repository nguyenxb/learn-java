<%--
  Created by IntelliJ IDEA.
  User: asd
  Date: 2021/7/3
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    @include 会将 两个页面合二为一--%>
<%--    网页的头--%>
    <%@include file="common/header.jsp"%>
    <h1>网页主体</h1>
<%--    网页的尾--%>
    <%@include file="common/footer.jsp"%>

<hr>

<%--jsp标签
    jsp:include ： 拼接页面，本质还是3个页面
--%>
<%--    网页的头--%>
<jsp:include page="common/header.jsp"/>
<h1>网页主体</h1>
<%--    网页的尾--%>
<jsp:include page="common/footer.jsp"/>


</body>
</html>
