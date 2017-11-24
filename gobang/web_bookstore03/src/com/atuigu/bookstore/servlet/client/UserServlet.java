package com.atuigu.bookstore.servlet.client;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atuigu.bookstore.domain.User;
import com.atuigu.bookstore.service.UserService;
import com.atuigu.bookstore.service.impl.UserServiceImpl;
import com.atuigu.bookstore.servlet.BaseServlet;
import com.atuigu.bookstore.util.WebUtils;

/**
 * 处理用户相关的请求 1. 注册 2. 登陆
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();

	/*
	 * 1. 注册
	 */
	public void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("regist()");

		// 1. 获取请求参数数据 
		// 2. 将数据封装成一个user对象
		User user = WebUtils.request2Bean(request, User.class);
		
		/*	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		String id = UUID.randomUUID().toString();// 生成一个36位的随机值作为id

		User user = new User(id, username, password, email);
		*/
		
		// 3. 调用userService对象的regist方法处理 -->返回一个boolean结果
		boolean success = userService.regist(user);
		// 4. 根据boolean结果转向到不同的页面
		if (success) {

			// 转发到login.jsp
			request.setAttribute("message", "注册成功, 可以登陆了!");
			request.getRequestDispatcher("/client/user/login.jsp").forward(
					request, response);
		} else {
			// 重定向到regist.jsp
			request.setAttribute("message", "注册失败, 此用户名已存在!");
			request.getRequestDispatcher("/client/user/regist.jsp").forward(
					request, response);
		}
	}

	/*
	 * 2. 登陆
	 */
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("login()");
		// 1. 获取请求参数数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 2. 调用userService对象的login方法处理 -->返回一个boolean结果
		boolean success = userService.login(username, password);
		// 3. 根据boolean结果转向到不同的页面
		if (success) {
			// 重定向到login_success.jsp
			response.sendRedirect(request.getContextPath()
					+ "/client/user/login_success.jsp");
		} else {
			// 转发到login.jsp
			request.setAttribute("message", "登陆失败, 用户名或密码错误!");
			request.getRequestDispatcher("/client/user/login.jsp").forward(
					request, response);
		}
	}
}
