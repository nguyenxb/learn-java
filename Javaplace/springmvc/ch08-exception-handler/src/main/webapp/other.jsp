<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>重定向</h1>
    <h2>通过el表达式取值</h2>
    <h3>myname: ${myname}</h3>
    <h3>myage: ${myage}</h3>
    <hr/>
    <h2>通过param集合</h2>
    <h3>myname: ${param.myname}</h3>
    <h3>myage: ${param.myage}</h3>
    <hr/>
    <h2>java代码取值</h2>
    <h3>myname: <%= request.getParameter("myname")%>></h3>
    <h3>myage:  <%= request.getParameter("myage")%></h3>

</body>
</html>
