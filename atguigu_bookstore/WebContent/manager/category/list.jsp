<%@page import="com.atguigu.web_bookstore.bean.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.atguigu.com/jsp/myjstl/atguigu" prefix="atguigu"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	width: 600px;
	border: 1px solid gray;
	border-collapse: collapse;
}

td {
	border: 1px solid gray;
	border-collapse: collapse;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-1.7.2.js"></script>
<script type="text/javascript">

	$(function(){
		$(".updateBtn").click(function(){
			var categoryid = this.name.trim();
			var name = $("#"+categoryid).val();
			if(name.trim()=="")
				return false;
			return true;
		});
		
		$("button").click(function(){
			if(window.confirm("你确认要删除"+this.title+"吗?")) {
				window.location = "${pageContext.request.contextPath }/manager/CategoryServlet?method=delete&id="+this.name;
			}
		});
	});
</script>

</head>

<body>
	<center>
		<h4>所有的分类</h4>
	<c:choose>
		<c:when test="${empty list}">
			<div style="color: red; font-size: 30px;">没有一个分类</div>
		</c:when>
		<c:otherwise>
			<table border="1" cellpadding="10" cellspacing="0">
				<colgroup>
					<col width="60%">
					<col width="20%">
					<col width="20%">
				</colgroup>
				<c:forEach var="category" items="${list}">
					<form action="${pageContext.request.contextPath }/manager/CategoryServlet" method="post">
						<input type="hidden" name="id" value="${category.id}" />
						<input type="hidden" name="method" value="update" />
						<tr>
							<td>
								${category.name } &nbsp;
								<input id="${category.id}" type="text" name="name" value="${category.name }" />
							</td>
							<td>
								<input class="updateBtn" name="${category.id}" type="submit" value=" 修 改 "/>
							</td>
							<td>
								<atguigu:checkcategory id="${category.id}">
									<button title="${category.name}" name="${category.id}">删除</button>
								</atguigu:checkcategory>
							</td>
						</tr>
					</form>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	</center>
	
</body>
</html>
<!-- 
	1. 使用jsp表达式和jsp脚本显示分类列表
	2. 修改前判断输入框的值是否为空串, 如果是不能提交
	3. 删除前提示确认框
 -->