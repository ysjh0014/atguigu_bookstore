package com.atguigu.web_bookstore.dao.impl;

import java.util.List;

import com.atguigu.web_bookstore.bean.OrderItem;
import com.atguigu.web_bookstore.dao.OrderItemDao;

/*
 * orderitems表操作的dao实现类 
 */
public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao {

	@Override
	public void batchInsert(Object[][] data) {
		String sql = "insert into orderitems values(?,?,?,?,?)";
		batch(sql, data);
	}

	@Override
	public List<OrderItem> getListByOrderId(String orderid) {
		String sql = "select * from orderitems where ordersid=?";
		return queryForList(sql, orderid);
	}

}
