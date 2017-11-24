package com.atguigu.web_bookstore.util;


import com.google.gson.Gson;
/*
 * json数据处理的工具类
 */
public class JsonUtils {

	/**
	 * 将一个对象转换成一个json字符串
	 * @param data
	 * @return
	 */
	public static String toJson(Object data) {
		Gson gson = new Gson();
		return gson.toJson(data);
	}
}
