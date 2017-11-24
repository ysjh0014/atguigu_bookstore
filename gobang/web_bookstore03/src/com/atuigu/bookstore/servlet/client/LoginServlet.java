package com.atuigu.bookstore.servlet.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atuigu.bookstore.service.UserService;
import com.atuigu.bookstore.service.impl.UserServiceImpl;

/**
 * 处理登陆的请求
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService = new UserServiceImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 获取请求参数数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2. 调用userService对象的login方法处理  -->返回一个boolean结果
		boolean success = userService.login(username, password);
		//3. 根据boolean结果转向到不同的页面
		if(success) {
			//重定向到login_success.jsp
			response.sendRedirect(request.getContextPath()+"/client/user/login_success.jsp");
		} else {
			//转发到login.jsp
			request.setAttribute("message", "登陆失败, 用户名或密码错误!");
			request.getRequestDispatcher("/client/user/login.jsp").forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
