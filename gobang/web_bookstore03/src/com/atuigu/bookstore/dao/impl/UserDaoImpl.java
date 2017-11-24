package com.atuigu.bookstore.dao.impl;

import com.atuigu.bookstore.dao.UserDao;
import com.atuigu.bookstore.domain.User;

public class UserDaoImpl extends BaseDao<User> implements UserDao {

	public UserDaoImpl() {
		super();
	}

	@Override
	public User getByName(String name) {
		String sql = "select * from users where username=?";
		return query(sql, name);
	}

	@Override
	public void insert(User user) {

		String sql = "insert into users values(?,?,?,?)";
		update(sql, user.getId(), user.getUsername(), user.getPassword(),
				user.getEmail());
	}

	@Override
	public User getByNameAndPwd(String name, String password) {
		String sql = "select * from users where username=? and password=?";
		return query(sql, name, password);
	}

}
