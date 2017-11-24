package com.atuigu.bookstore.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

/*
 * Serlvet中的一些处理web请求的相关工具方法的类
 */
public class WebUtils {

	/**
	 * 实现对请求参数到实体类对象的自动收集封装
	 * @param request
	 * @param beanClass
	 * @return
	 */
	public static <T> T request2Bean(HttpServletRequest request, Class<T> beanClass) {
		T t = null;
		
		try {
			//创建一个空对象
			t = beanClass.newInstance();  //调用无参数的构造方法(必须有)
			//取出request所有的请求参数数据(参数名, 参数值)
			Enumeration parameterNames = request.getParameterNames();
			
			//如果请求中没有携带id参数, 必须创建一个并设置进去 
			String id = request.getParameter("id");
			if(id==null || "".equals(id.trim())) {
				id = UUID.randomUUID().toString();
				BeanUtils.copyProperty(t, "id", id);
			}
			//取出所有的参数并设置到t对象中
			while(parameterNames.hasMoreElements()) {
				String name = (String) parameterNames.nextElement();  //username setUsername
				String value = request.getParameter(name);
				//将name和value设置到t对象的对应属性中
				BeanUtils.copyProperty(t, name, value);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
}
