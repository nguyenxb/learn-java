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
		<% 
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			request.setAttribute("username", username);
			request.setAttribute("password",password);
		%>
		
		<c:if test="${loginCount==null || loginCount==''} ">
			<% 
				session.setAttribute("loginCount",0);				
			%>
		</c:if>
	<!-- 如果用户名和密码正确,并且登录失败次数小于三, 则进入系统 -->
	<c:if test="${username=='hqq' &&  password=='20w1' && loginCount <= 3}">
		<jsp:forward page="hello.jsp">
			<jsp:param value="${username }" name="username"/>
		</jsp:forward>
	</c:if>
	<!-- 如果用户名和密码不正确, 则返回登录界面 -->
	<c:if test="${username != 'hqq' || password != '20w1' }">
		
			<% 
				int loginCount = (int)session.getAttribute("loginCount");
				
				session.setAttribute("loginCount",loginCount+1);
			%>
		<% request.setAttribute("msg", "用户名或密码不正确");
		%>
		<jsp:forward page="login.jsp"></jsp:forward>
		
	</c:if>

</body>
</html>