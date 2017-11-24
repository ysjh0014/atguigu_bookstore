package com.atuigu.bookstore.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 所有实现Servlet的父类
 * 	将请求交给对应的处理方法去处理
 */
public abstract class BaseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String methodName = req.getParameter("method");
		System.out.println("baseServlet "+methodName);
		/*
		 * if("regist".equals(methodName)) { regist(request, response); } else
		 * if("login".equals(methodName)) { login(request, response); } else
		 * if("list".equals(methodName)) { list(request, response); }
		 */

		// 反射
		// 得到要调用的方法所对应的mehtod对象
		try {
			Method method = getClass().getMethod(methodName,
					HttpServletRequest.class, HttpServletResponse.class); //只能得到public的方法
			method.invoke(this, req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
