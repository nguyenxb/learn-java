<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if("${loginCount}">3){
		alert("进入登录次数已经达到,请明日登录");
	}
	
</script>

</head>
<body>	
		<div align="center">
			<form action="checkLogin.jsp">
			<table id="loggin_tab" border="1"  rules="all">
				<caption >用户登录</caption>
				<tr>
					<th>用戶名:</th>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<th>密码:</th>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="登录">&nbsp;
						<input type="reset" value="重置">&nbsp;
						<a href='register.jsp'><input type="button" value="注册"></a>
					</td>
				</tr>
			</table>
			</form>
			<span id="msg">${msg}</span>
			<span id="loginCount">已经登录失败次数 : ${loginCount}</span>
		</div>
</body>
</html>