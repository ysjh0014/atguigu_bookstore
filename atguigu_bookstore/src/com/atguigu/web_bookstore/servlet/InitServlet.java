package com.atguigu.web_bookstore.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.atguigu.web_bookstore.factory.BeanFactory;

/**
 * 用来读取数据源的初始化Servlet
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    public void init() throws ServletException {
    	BeanFactory.init();
    }
}
