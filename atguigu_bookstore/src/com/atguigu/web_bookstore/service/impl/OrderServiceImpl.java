package com.atguigu.web_bookstore.service.impl;

import java.util.List;
import java.util.UUID;

import com.atguigu.web_bookstore.bean.Address;
import com.atguigu.web_bookstore.bean.Book;
import com.atguigu.web_bookstore.bean.Cart;
import com.atguigu.web_bookstore.bean.CartItem;
import com.atguigu.web_bookstore.bean.Order;
import com.atguigu.web_bookstore.bean.OrderItem;
import com.atguigu.web_bookstore.dao.AddressDao;
import com.atguigu.web_bookstore.dao.BookDao;
import com.atguigu.web_bookstore.dao.CategoryDao;
import com.atguigu.web_bookstore.dao.OrderDao;
import com.atguigu.web_bookstore.dao.OrderItemDao;
import com.atguigu.web_bookstore.dao.impl.AddressDaoImpl;
import com.atguigu.web_bookstore.dao.impl.BookDaoImpl;
import com.atguigu.web_bookstore.dao.impl.OrderDaoImpl;
import com.atguigu.web_bookstore.dao.impl.OrderItemDaoImpl;
import com.atguigu.web_bookstore.factory.BeanFactory;
import com.atguigu.web_bookstore.service.OrderService;
import com.atguigu.web_bookstore.util.WebUtils;

/*
 * 订单相关操作的业务实现类
 */
public class OrderServiceImpl implements OrderService {

	private AddressDao addressDao = BeanFactory.get(AddressDao.class);
	private OrderDao orderDao = BeanFactory.get(OrderDao.class);
	private OrderItemDao orderItemDao = BeanFactory.get(OrderItemDao.class);
	private BookDao bookDao = BeanFactory.get(BookDao.class);
	

	@Override
	public void addAddress(Address address) {
		addressDao.insert(address);
	}

	@Override
	public String makeOrder(String userId, String addressId, Cart cart) {
		
		//更新books表
		Object[][] data = new Object[cart.getMap().size()][3];
		int index = 0;
		for(CartItem cartItem : cart.getMap().values()) {
			data[index][0] = cartItem.getCount();
			data[index][1] = cartItem.getCount();
			data[index][2] = cartItem.getBook().getId();
			index++;
		}
		bookDao.batchUpdateStoreAndSale(data);
		
		//更新orders表
		String orderNumber = WebUtils.buildOrderid(orderDao.getTodayCount()+1);//生成订单号
		Order order = new Order(UUID.randomUUID().toString(), orderNumber, false, cart.getTotalPrice(), null, userId, addressId);
		orderDao.insert(order);
		
		//更新orderItem表
		data = new Object[cart.getMap().size()][5];
		index = 0;
		for(CartItem cartItem : cart.getMap().values()) {
			data[index][0] = UUID.randomUUID().toString();
			data[index][1] = cartItem.getCount();
			data[index][2] = cartItem.getItemPrice();
			data[index][3] = order.getId();
			data[index][4] = cartItem.getBook().getId();
			index++;
		}
		orderItemDao.batchInsert(data);
		
		return orderNumber;
	}

	@Override
	public List<Address> getAdressesByUserId(String userid) {
		
		return addressDao.getListByUserId(userid);
	}

	@Override
	public List<Order> getOrdersByUserId(String userId) {
		
		return orderDao.getListByUserId(userId);
	}

	@Override
	public List<OrderItem> getOrderItemsByOrderId(String orderid) {
		List<OrderItem> list = orderItemDao.getListByOrderId(orderid);
		for(OrderItem item : list) {
			Book book = bookDao.getById(item.getBooksid());
			item.setBook(book);
		}
		return list;
	}

	@Override
	public Address getAdressByAddresId(String addressid) {
		
		return addressDao.getById(addressid);
	}

	@Override
	public List<Order> getOrdersByStatus(boolean status) {
		
		return orderDao.getListByStatus(status);
	}

	@Override
	public void send(String orderid) {
		orderDao.updateStatus(orderid);
	}

}
