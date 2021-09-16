<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: asd
  Date: 2021/7/3
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        // 定义集合，将数据存入集合
        ArrayList<String> people = new ArrayList<String>();
        people.add("张三");
        people.add("李四");
        people.add("王五");
        people.add("赵六");
        people.add("前七");

        request.setAttribute("list",people);

    %>

<%--
    var = "people" 定义一个变量, people
    items = "${list}}" 要遍历的对象 list
    等价于java代码:
     for (String people:list) {
            out.print(people);
        }
--%>
<c:forEach var="people" items="${list}">
    名字：<c:out value="${people}"></c:out> <br>
</c:forEach>

<hr>

<%--
    var="people" 定义一个变量，people
     items="${list}" ,要遍历的对象，list
      begin="1" , 开始遍历的位置
      end="3"   , 结束遍历的位置
      step="2"  , 步长
       等价于java代码:
        ArrayList<String> people = new ArrayList<String>();
        people.add("张三");
        people.add("李四");
        people.add("王五");
        people.add("赵六");
        people.add("前七");

        request.setAttribute("list",people);
        people = (ArrayList<String>) request.getAttribute("list");

        for (int i = 1; i <= 3; i+=2) {
            String temp = people.get(i);
            out.println(temp);
        }
--%>

<c:forEach var="people" items="${list}" begin="1" end="3" step="2">
    名字：<c:out value="${people}"></c:out> <br>
</c:forEach>



</body>
</html>
