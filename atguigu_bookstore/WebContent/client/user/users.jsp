<%@page import="com.atguigu.web_bookstore.bean.OnLineBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>目前共有${OnLineBean.totalCount}人在线，其中登陆用户${OnLineBean.userCount}</h2>
		<table border="1" width="400px" style="text-align: center;" cellpadding="10" cellspacing="0">
	   		<tr style="background-color: gray;">
	   			<td>登陆用户列表</td>
	   		</tr>
	   		<c:choose>
	   			<c:when test="${empty OnLineBean.userMap}">
	   				<tr>
			   			<td>无</td>
			   		</tr>
	   			</c:when>
	   			<c:otherwise>
	   				<c:forEach var="item" items="${OnLineBean.userMap}">
				   		<tr>
				   			<td>${item.value }</td>
				   		</tr>
			   		</c:forEach>
	   			</c:otherwise>
	   		</c:choose>
	   		<tr style="background-color: gray;">
	   			<td>匿名用户列表</td>
	   		</tr>
	   		<c:choose>
	   			<c:when test="${empty OnLineBean.visitorSet}">
	   				<tr>
			   			<td>无</td>
			   		</tr>
	   			</c:when>
	   			<c:otherwise>
	   				<c:forEach var="item" items="${OnLineBean.visitorSet}">
				   		<tr>
				   			<td>${item}</td>
				   		</tr>
			   		</c:forEach>
	   			</c:otherwise>
	   		</c:choose>
	   		
	   	</table>
	</center>
	
</body>
</html>