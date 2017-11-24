package com.atguigu.web_bookstore.service;

import com.atguigu.web_bookstore.bean.User;
/*
 * 注册用户相关操作的业务接口
 */
public interface UserService {

	/**
	 * 注册
	 * @param user
	 * @return
	 */
	boolean regist(User user);
	/**
	 * 登陆
	 * @param username
	 * @param password
	 * @return
	 */
	User login(String username, String password);

	/**
	 * 根据id得到用户对象
	 * @param usersid
	 * @return
	 */
	User getUserById(String usersid);

	/**
	 * 检查用户名是否已存在
	 * @param username
	 * @return
	 */
	boolean checkNameExist(String username);
}
