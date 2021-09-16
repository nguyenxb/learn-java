<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
<%--  在 jsp 文件中写java--%>
  <% System.out.print("ruasib");%>
  <% System.out.print("阿迪");%>
  <h4>name=${out.print("阿迪")}</h4>
  <h4>name=${out.print("ruasib")}</h4>
  </body>
</html>
