<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
//    People people = new People();
%>
<jsp:useBean id="people" class="com.ruasib.People" scope="page"></jsp:useBean>

<%
//    people.setId(1);
//    people.setName("阿笛");
//    people.setAge(10);
//    people.setAddress("asd");
%>
<jsp:setProperty name="people" property="id" value="1"></jsp:setProperty>
<jsp:setProperty name="people" property="name" value="阿笛"></jsp:setProperty>
<jsp:setProperty name="people" property="age" value="10"></jsp:setProperty>
<jsp:setProperty name="people" property="address" value="asd"></jsp:setProperty>

<%

// out.print(people.getId());
// out.print(people.getName());
// out.print(people.getAge());
// out.print(people.getAddress());
%>

id:<jsp:getProperty name="people" property="id"/>
name:<jsp:getProperty name="people" property="name"/>
age:<jsp:getProperty name="people" property="age"/>
address:<jsp:getProperty name="people" property="address"/>


</body>
</html>