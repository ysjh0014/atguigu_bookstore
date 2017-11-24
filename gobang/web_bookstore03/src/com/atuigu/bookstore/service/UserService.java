package com.atuigu.bookstore.service;

import com.atuigu.bookstore.domain.User;

/*
 * 处理用户相关业务的接口
 */
public interface UserService {

	/**
	 * 处理注册的功能
	 * @param user
	 * @return
	 */
	public boolean regist(User user);
	
	/**
	 * 处理登陆的功能
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean login(String username, String password);
}
