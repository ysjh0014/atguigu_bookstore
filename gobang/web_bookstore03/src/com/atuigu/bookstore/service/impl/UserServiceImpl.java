package com.atuigu.bookstore.service.impl;

import com.atuigu.bookstore.dao.UserDao;
import com.atuigu.bookstore.dao.impl.UserDaoImpl;
import com.atuigu.bookstore.domain.User;
import com.atuigu.bookstore.service.UserService;

/*
 * 处理用户相关业务的实现类
 */
public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public boolean regist(User user) {
		
		User dbUser = userDao.getByName(user.getUsername());
		if(dbUser==null) {
			userDao.insert(user);
			return true;
		}
		return false;
		
	}

	@Override
	public boolean login(String username, String password) {
		return userDao.getByNameAndPwd(username, password)!=null;
	}

}
