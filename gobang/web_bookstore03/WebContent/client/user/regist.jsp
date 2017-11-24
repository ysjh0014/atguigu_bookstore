<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/user.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
/* 
	用户名: 长度为6到12位, 只能输入数字和英文和下划线
	密码: 长度为6位, 只能输入数字和英文
	确认密码: 必须与密码相同
	邮箱: 格式必须正确, 可以不输入 
	如果有一个不合法, 则显示警告, 且对应的输入框自动获得焦点
*/
$(function(){
	
	function check($inputEle, valide, message) {
		if(!valide) {
			alert(message);
			$inputEle.focus();
			return false;
		}
		return true;
	}
	
	$("#registBtn").click(function(){
		//用户名: 长度为6到12位, 只能输入数字和英文和下划线
		var $nameEle = $("#username");
		var name = $nameEle.val();
		var reg = /^\w{6,12}$/;
		var result = check($nameEle, reg.test(name), "用户名的长度必须为6到12位, 只能输入数字和英文和下划线");
		if(!result)
			return false;
		
		/* if(!reg.test(name)) {
			alert("用户名的长度必须为6到12位, 只能输入数字和英文和下划线");
			$nameEle.focus();
			return false;//不提交
		} */
		
		
		//密码: 长度为6位, 只能输入数字和英文
		
		var $passwordEle = $("#password");
		var password = $passwordEle.val();
		reg = /^[a-zA-Z0-9]{6}$/;
		
		result = check($passwordEle, reg.test(password), "密码的长度为6位, 只能输入数字和英文");
		if(!result)
			return false;
		
		/* if(!reg.test(password)) {
			alert("密码的长度为6位, 只能输入数字和英文");
			$passwordEle.focus();
			return false;//不提交
		} */
		
		//确认密码: 必须与密码相同
		var $password2Ele = $("#password2");
		var password2 = $password2Ele.val();
		
		result = check($password2Ele, password==password2, "确认密码必须与密码相同");
		if(!result)
			return false;
		/* 
		if(password!=password2) {
			alert("确认密码必须与密码相同");
			$password2Ele.focus();
			return false;//不提交
		} */
		
		//邮箱: 格式必须正确, 可以不输入 
		var $emailEle = $("#email");
		var email = $emailEle.val();
		reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		
		result = check($emailEle, email.trim().length<=0 || reg.test(email), "邮箱格式必须正确, 可以不输入");
		if(!result)
			return false;
		/* 
		if(email.trim().length>0 && !reg.test(email)) {
			alert("邮箱格式必须正确, 可以不输入");
			$emailEle.focus();
			return false;//不提交
		} */
	});
});
	

	
</script>
</head>
<body>
	<div align="center">
		<div style="color: red">
			<%=request.getAttribute("message")==null ? "" : request.getAttribute("message")%>
		</div>
	
		<form action="<%=request.getContextPath() %>/client/UserServlet" method="post">
			<!-- 使用隐藏域的保存请求参数 -->
			<input type="hidden" name="method" value="regist"/>
			<table>

				<colgroup>
					<col width="30%">
					<col width="70%">
				</colgroup>

				<tr>
					<td colspan="2"
						style="background: #00FFFF; height: 40px; font-size: 25px; text-align: center;">新用户注册</td>
				</tr>
				<tr>
					<td>用户名：</td>
					<td>
						<input id="username" type="text" name="username" class="input" 
							value='<%=request.getParameter("username")==null ? "" 
									: request.getParameter("username")%>'/>
					</td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input id="password" type="password" name="password"
						class="input" value="123456" /></td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><input id="password2" type="password" name="password2"
						class="input" value="123456" /></td>
				</tr>
				<tr>
					<td>邮箱：</td>
					<td><input id="email" type="text" name="email" class="input" value='<%=request.getParameter("email")==null ? "" : request.getParameter("email")%>'/></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;"><input
						id="registBtn" type="submit" value="立即注册" />&nbsp;&nbsp;&nbsp; <a
						href="<%=request.getContextPath() %>/client/user/login.jsp">登 陆</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>