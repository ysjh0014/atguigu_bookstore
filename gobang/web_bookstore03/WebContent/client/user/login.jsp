<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/user.css">
</head>
<body>
	<div align="center">
	
		<div style="color: red">
			${message}
		</div>
		
		<form action="<%=request.getContextPath() %>/client/UserServlet" style="width: 400px;"
			method="post">
			<!-- 使用隐藏域的保存请求参数 -->
			<input type="hidden" name="method" value="login"/>
			<table>
				<colgroup>
					<col width="30%">
					<col width="*%">
				</colgroup>
				<tr>
					<td colspan="2"
						style="background: #00FFFF; height: 40px; font-size: 25px; text-align: center;">用户登录</td>
				</tr>
				<tr>
					<td>用户名：</td>
					<td><input class="input" type="text" name="username" value='${param.username }'></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input class="input" type="password" name="password"></td>
				</tr>
				<tr background="#020202">
					<td align="center" colspan="2">
						<input class="OperBtn" type="submit" value=" 登 录 " />&nbsp;&nbsp;&nbsp; 
						<a href="<%=request.getContextPath() %>/client/user/regist.jsp"> 注 册 </a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>