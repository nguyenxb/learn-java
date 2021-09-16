<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.net.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>基本资料</h1>
	姓名: <%= URLEncoder.encode(request.getParameter("username"),"UTF-8") %> <br/>
	性别: <%= URLEncoder.encode(request.getParameter("gender"),"UTF-8") %><br/>
	民族: <%= URLEncoder.encode(request.getParameter("nation"),"UTF-8") %><br/>
	专业: <%= URLEncoder.encode(request.getParameter("job"),"UTF-8") %><br/>
	兴趣爱好:
		<%  String[] inters = request.getParameterValues("inters");
		for(String inter: inters){
			%>
			<%= URLEncoder.encode(request.getParameter("inter"),"UTF-8")+" " %>
			<% 
		}
		%>
	
	
	
<%-- 	性别: <%= request.getParameter("gender") %><br/>
	民族: <%= request.getParameter("nation") %><br/>
	专业: <%= request.getParameter("job") %><br/>
	兴趣爱好:
	
	<% 
		String[] inters = request.getParameterValues("inters");
		for(String inter: inters){
			out.print(inter+",");
		}
	%> --%>
	
</body>
</html>