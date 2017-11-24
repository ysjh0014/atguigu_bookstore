package com.atguigu.web_bookstore.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.web_bookstore.bean.Address;
import com.atguigu.web_bookstore.bean.Order;
import com.atguigu.web_bookstore.bean.OrderItem;
import com.atguigu.web_bookstore.bean.User;
import com.atguigu.web_bookstore.factory.BeanFactory;
import com.atguigu.web_bookstore.service.OrderService;
import com.atguigu.web_bookstore.service.UserService;
import com.atguigu.web_bookstore.servlet.BaseServlet;
import com.atguigu.web_bookstore.util.TransacationProxyUtils;
import com.atguigu.web_bookstore.util.WebUtils;

/**
 * 后台订单相关处理的Servlet
 * 1. 显示某个状态的所有订单
 * 2. 显示某个订单详情
 * 3. 发货
 */
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private OrderService orderService = TransacationProxyUtils.getProxy(BeanFactory.get(OrderService.class));
	private UserService userService = TransacationProxyUtils.getProxy(BeanFactory.get(UserService.class));

	/*
	 * 1. 显示某个状态的所有订单
	 */
	public void showOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		System.out.println("---OrderServlet showOrders()");

		String statusString = request.getParameter("status");
		boolean status = false;
		try {
			status = Boolean.parseBoolean(statusString);
		} catch (Exception e) {

		}
		List<Order> list = orderService.getOrdersByStatus(status);

		WebUtils.forword(request, response, "/manager/order/orders.jsp", "orders", list);
	}
	
	/*
	 * 2. 显示某个订单详情
	 */
	public void showOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		System.out.println("---OrderServlet showOrder()");

		String orderid = request.getParameter("orderid");
		String addressid = request.getParameter("addressid");

		List<OrderItem> orderItems = orderService.getOrderItemsByOrderId(orderid);
		Address address = orderService.getAdressByAddresId(addressid);
		User user = userService.getUserById(address.getUsersid());

		request.setAttribute("orderItems", orderItems);
		request.setAttribute("address", address);
		request.setAttribute("user", user);

		request.getRequestDispatcher("/manager/order/order.jsp").forward(request, response);
	}

	/*
	 *  3. 发货
	 */
	public void send(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		System.out.println("---OrderServlet send()");

		String orderid = request.getParameter("orderid");
		
		orderService.send(orderid);
		
		WebUtils.forwordMessageUI(request, response, "发货成功");
	}

}
