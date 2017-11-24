package com.atguigu.web_bookstore.service;

import com.atguigu.web_bookstore.bean.Book;
import com.atguigu.web_bookstore.bean.Cart;
/*
 * 购物车相关功能业务的接口
 */
public interface CartService {

	/**
	 * 添加一本书到购物车
	 * @param cart
	 * @param book
	 * @return
	 */
	String addBook(Cart cart, Book book);

	/**
	 * 删除一个购物项
	 * @param cart
	 * @param bookid
	 */
	void deleteItem(Cart cart, String bookid);

	/**
	 * 更新某个购物项
	 * @param cart
	 * @param bookid
	 * @param count
	 * @return
	 */
	String updateItem(Cart cart, String bookid, int count);

	/**
	 * 清空购物车
	 * @param cart
	 */
	void clear(Cart cart);
	
}
