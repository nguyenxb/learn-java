<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>if 测试</h4>
   <form action="coreIf.jsp" method="get">
<%--
    使用EL表达式获取表单中的数据
       语法：${param.参数名}
--%>
       <label>
           <input type="text" name="username" value="${param.username}">
           <input type="submit" value="登录">
       </label>
   </form>

<%--判断如果用户名是管理员，则登录成功--%>
<%-- 登录java代码实现
<%
    if (request.getParameter("username").equals("admin")){
        out.print("登录成功");
    }
%>
--%>
<%--判断如果提交的用户是管理员，则登录成功--%>
<c:if test="${param.username=='admin'}" var="isAdmin">
    <c:out value="管理员欢迎你"></c:out>
</c:if>

<c:out value="${isAdmin}"></c:out>

</body>
</html>
