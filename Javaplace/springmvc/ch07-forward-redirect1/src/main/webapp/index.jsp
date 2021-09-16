<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="controller/doForward.do">发起/controller/doForward.do请求</a>
    <form action="controller/doRedirect.do">
       <input type="text" name="name" value="lisi"/>
        <input type="text" name="age" value="90"/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
