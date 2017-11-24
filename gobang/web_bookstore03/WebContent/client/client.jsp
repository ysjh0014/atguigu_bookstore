<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  type="text/css" href="<%=request.getContextPath() %>/css/index.css">
</head>
<body>
	<div id="top">
		<div id="title">WEB在线书城欢迎你!</div>
		<div>
			<a target="content" href="<%=request.getContextPath() %>/client/user/login.jsp">登陆</a> 
			｜
			<a target="content" href="<%=request.getContextPath() %>/client/user/regist.jsp">注册</a>
		</div>
	</div>
	<div id="down">
		<div id="left">
			<a href="#">全部分类</a><br> 
			<a href="#">计算机与互联网</a><br> 
			<a href="#">科学</a><br>
		</div>
		<div id="right">
			<iframe name="content" style="width: 100%; height: 100%;"
				src="<%=request.getContextPath() %>/default.jsp"> </iframe>
		</div>
	</div>
</body>
</html>