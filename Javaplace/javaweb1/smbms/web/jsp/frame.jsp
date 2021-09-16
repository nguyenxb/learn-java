<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.nguyenxb.entity.User" %>
<%@page import="com.nguyenxb.util.Constants" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../jsp/common/head.jsp"%>
<div class="right">
    <img class="wColck" src="../images/clock.jpg" alt=""/>
    <div class="wFont">
        <h2>${Contants.USER_SESSION}</h2>
        <p>欢迎来到超市订单管理系统!</p>
    </div>
</div>
</section>
<%@include file="../jsp/common/foot.jsp" %>
