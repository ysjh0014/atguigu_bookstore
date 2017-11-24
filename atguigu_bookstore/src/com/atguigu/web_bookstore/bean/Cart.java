package com.atguigu.web_bookstore.bean;

import java.util.HashMap;
import java.util.Map;
/*
 * 购物车信息封装类
 */
public class Cart {

	private Map<String, CartItem> map = new HashMap<String, CartItem>();

	public Map<String, CartItem> getMap() {
		return map;
	}

	/*
	 * 得到书的总数量
	 */
	public int getTotalCount() {
		int total = 0;
		for (CartItem cartItem : map.values()) {
			total += cartItem.getCount();
		}
		return total;
	}

	/*
	 * 得到总价格
	 */
	public float getTotalPrice() {
		float total = 0;

		for (CartItem cartItem : map.values()) {
			total += cartItem.getItemPrice();
		}
		return total;
	}

}
