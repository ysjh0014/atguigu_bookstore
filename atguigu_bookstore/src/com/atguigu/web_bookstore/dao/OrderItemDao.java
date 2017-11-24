package com.atguigu.web_bookstore.dao;

import java.util.List;

import com.atguigu.web_bookstore.bean.OrderItem;
/*
 * orderitems表操作的dao接口
 */
public interface OrderItemDao {

	/**
	 * 批量插入数据
	 * @param data
	 */
	public void batchInsert(Object[][] data);

	/**
	 * 得到某个订单id所对应的所有订单项的集合
	 * @param orderid
	 * @return
	 */
	public List<OrderItem> getListByOrderId(String orderid);
}
