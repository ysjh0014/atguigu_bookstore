package com.atuigu.bookstore.servlet.client;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atuigu.bookstore.domain.User;
import com.atuigu.bookstore.service.UserService;
import com.atuigu.bookstore.service.impl.UserServiceImpl;

/**
 * 处理注册的请求
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserService userService = new UserServiceImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RegistServlet()");
		
		//1. 获取请求参数数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		
		String id = UUID.randomUUID().toString();//生成一个36位的随机值作为id
		
		//2. 将数据封装成一个user对象
		User user = new User(id, username, password, email);
		//3. 调用userService对象的regist方法处理  -->返回一个boolean结果
		boolean success = userService.regist(user);
		//4. 根据boolean结果转向到不同的页面
		if(success) {
		
			//转发到login.jsp
			request.setAttribute("message", "注册成功, 可以登陆了!");
			request.getRequestDispatcher("/client/user/login.jsp").forward(request, response);
		} else {
			//重定向到regist.jsp
			request.setAttribute("message", "注册失败, 此用户名已存在!");
			request.getRequestDispatcher("/client/user/regist.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
