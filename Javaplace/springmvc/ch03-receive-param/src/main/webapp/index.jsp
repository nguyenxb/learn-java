<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求方式</title>
</head>
<body>
    <p>逐个接收请求参数</p>
    <form action="receive-param1.do" method="post">
        姓名:<input type="text" name="name">
        年龄:<input type="text" name="age">
        <input type="submit" value="提交参数">
    </form>

    <p>逐个接收请求参数: 请求中参数名和形参名不一样</p>
    <form action="receive-param2.do" method="post">
        姓名:<input type="text" name="AAname">
        年龄:<input type="text" name="AAage">
        <input type="submit" value="提交参数">
    </form>

    <p>对象接收请求参数: 请求中参数名和对象的属性名一样</p>
    <form action="receive-param3.do" method="post">
        姓名:<input type="text" name="name">
        年龄:<input type="text" name="age">
        <input type="submit" value="提交参数">
    </form>

</body>
</html>
