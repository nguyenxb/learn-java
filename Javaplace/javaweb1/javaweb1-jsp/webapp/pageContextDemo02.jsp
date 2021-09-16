<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        //从 pageContext取出，我们通过寻找的方式来找出其中的数据
        String name1 = (String) pageContext.findAttribute("name1");
        String name2 = (String) pageContext.findAttribute("name2");
        String name3 = (String) pageContext.findAttribute("name3");
        String name4 = (String) pageContext.findAttribute("name4");
        String name5 = (String) pageContext.findAttribute("name5"); // 不存在
    %>
    <%--
        注意：EL表达式 `  ${ 变量或者表达式} ` 等价于 ` <%= 变量或者表达式 %> `
    --%>
    <h1>页面二，只取数据的页面</h1>
    <h1>EL 表达式取出的值：</h1>
    <h4>${name1}</h4>
    <h4>${name2}</h4>
    <h4>${name3}</h4>
    <h4>${name4}</h4>
    <h4 style="color: yellow">${name5}</h4>
    <h4 style="color: red"><%= name5%></h4>
</body>
</html>
