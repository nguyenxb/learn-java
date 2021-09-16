<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= session.getAttribute("loginCount") %>
		<h1>${loginTimes}</h1>
	<h1>登录成功</h1>
	<c:if test="${userNum==null || userNum==''}">
		<% 
			application.setAttribute("userNum",1);
		%>
	</c:if>
	<c:if test="${userNum!=null && userNum !=''}">
		<h3>${username} 您好,欢迎您!</h3>
		<h3>您是第${userNum}位进入系统的用户 </h3>
		<% 
			int userNum = (int)application.getAttribute("userNum");
			application.setAttribute("userNum", userNum+1);
		%>
	</c:if>
	
</body>
</html>