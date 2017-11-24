package com.atguigu.web_bookstore.servlet.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.web_bookstore.bean.Category;
import com.atguigu.web_bookstore.factory.BeanFactory;
import com.atguigu.web_bookstore.service.CategoryService;
import com.atguigu.web_bookstore.servlet.BaseServlet;
import com.atguigu.web_bookstore.util.TransacationProxyUtils;
import com.atguigu.web_bookstore.util.WebUtils;

/*
 * 处理进入前台的请求
 */
public class ClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private CategoryService categoryService = TransacationProxyUtils.getProxy(BeanFactory.get(CategoryService.class));
	
	public void toClientUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WebUtils.checkUser(request, response);
		
		List<Category> allCategorys = categoryService.getAllCategorys();
		WebUtils.forword(request, response, "/client/client.jsp", "allCategorys", allCategorys);
	}

}
