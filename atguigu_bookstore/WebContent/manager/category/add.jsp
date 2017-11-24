<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$("#nameText")[0].focus();
		
		$("#addBtn").click(function(){
			var name = $("#nameText").val();
			if(name.trim()=="") {
				$("#nameText")[0].focus();
				alert("分类名称不能为空");
				return false;
			} else {
				return true;
			}
		});
	});
</script>
</head>
	<body style="text-align: center; padding-top: 20px;">
	
		<div style="font-size: 15px; color: red">${message}</div>
		
		<form action="${pageContext.request.contextPath }/manager/CategoryServlet?method=add" method="post">
			分类名称 : <input id="nameText" type="text" name="name" value="${param.name}" /><br>
			
			<input id="addBtn" type="submit" value="添加分类" />
		</form>
	</body>
</html>

<!-- 
	1. 分类名称的输入框自动获得焦点
	2. 如果提交的分类是空串或空格, 显示警告不能提交
	3. 提交添加分类后,如果失败了显示失败原因(此分类已存在)
 -->
