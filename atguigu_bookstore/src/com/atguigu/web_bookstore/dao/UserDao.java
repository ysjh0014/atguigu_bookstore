package com.atguigu.web_bookstore.dao;

import com.atguigu.web_bookstore.bean.User;

/*
 * users表操作的dao接口
 */
public interface UserDao {

	/**
	 * 根据用户名得到对应的记录对象
	 * @param username
	 * @return
	 */
	User getByName(String username);

	/**
	 * 插入一条记录
	 * @param user
	 */
	void insert(User user);

	/**
	 * 根据用户名和密码得到对应的记录对象
	 * @param username
	 * @param password
	 * @return
	 */
	User getByNameAndPwd(String username, String password);

	/**
	 * 根据id得到对应的记录对象
	 * @param usersid
	 * @return
	 */
	User getById(String usersid);
}
