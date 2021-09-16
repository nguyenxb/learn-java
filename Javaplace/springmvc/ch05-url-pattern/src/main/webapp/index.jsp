<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求方式</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
</head>
<body>
    <p>中央调度器 使用 / </p>
    <form action="some.do" method="post">
        姓名:<input type="text" name="name">
        年龄:<input type="text" name="age">
        <input type="submit" value="提交参数">
    </form>

</body>
</html>
