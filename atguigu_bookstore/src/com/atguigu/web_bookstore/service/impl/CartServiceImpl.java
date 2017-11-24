package com.atguigu.web_bookstore.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.atguigu.web_bookstore.bean.Book;
import com.atguigu.web_bookstore.bean.Cart;
import com.atguigu.web_bookstore.bean.CartItem;
import com.atguigu.web_bookstore.service.CartService;
import com.atguigu.web_bookstore.util.JsonUtils;
/*
 * 购物车相关功能业务的实现类
 */
public class CartServiceImpl implements CartService {

	@Override
	public String addBook(Cart cart, Book book) {
		Map<String, CartItem> map = cart.getMap();
		CartItem cartItem = map.get(book.getId());
		if (cartItem == null) {
			cartItem = new CartItem(book, 1);
			map.put(book.getId(), cartItem);
		} else {
			cartItem.setCount(cartItem.getCount() + 1);
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("totalCount", cart.getTotalCount());
		resultMap.put("name", book.getName());
		return JsonUtils.toJson(resultMap);
	}

	@Override
	public void deleteItem(Cart cart, String bookid) {
		if (cart != null) {
			cart.getMap().remove(bookid);
		}
	}

	@Override
	public String updateItem(Cart cart, String bookid, int count) {
		CartItem cartItem = cart.getMap().get(bookid);
		cartItem.setCount(count);

		//"{"count":2,"itemTotalPrice":23,"totalPrice":2323,totalCount:23}"
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", count);
		map.put("itemTotalPrice", cartItem.getItemPrice());
		map.put("totalPrice", cart.getTotalPrice());
		map.put("totalCount", cart.getTotalCount());

		return JsonUtils.toJson(map);
	}

	@Override
	public void clear(Cart cart) {
		cart.getMap().clear();
	}

}
