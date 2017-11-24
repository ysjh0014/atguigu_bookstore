package com.atguigu.web_bookstore.service.impl;

import com.atguigu.web_bookstore.bean.User;
import com.atguigu.web_bookstore.dao.UserDao;
import com.atguigu.web_bookstore.factory.BeanFactory;
import com.atguigu.web_bookstore.service.UserService;
/*
 * 注册用户相关操作的业务实现类
 */
public class UserServiceImpl implements UserService {

	private UserDao userDao = BeanFactory.get(UserDao.class);

	@Override
	public boolean regist(User user) {
		User dbUser = userDao.getByName(user.getUsername());
		if (dbUser != null) {
			return false;
		}
		userDao.insert(user);
		return true;
	}

	public User login(String username, String password) {

		return userDao.getByNameAndPwd(username, password);
	}

	@Override
	public User getUserById(String usersid) {
		return userDao.getById(usersid);
	}

	@Override
	public boolean checkNameExist(String username) {
		User user = userDao.getByName(username);
		
		return user!=null;
	}
}
