<%--@elvariable id="userSession" type="com.nguyenxb.entity.User"--%>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.nguyenxb.entity.User" %>
<%@page import="com.nguyenxb.util.Constants" %>

<%@include file="../jsp/common/head.jsp"%>

<div class="right">
    <img class="wColck" src="../images/clock.jpg" alt=""/>
    <div class="wFont">
        <h2>${userSession.userName}</h2>
        <p>欢迎来到超市订单管理系统!</p>
    </div>
</div>
</section>
<%@include file="../jsp/common/foot.jsp" %>
