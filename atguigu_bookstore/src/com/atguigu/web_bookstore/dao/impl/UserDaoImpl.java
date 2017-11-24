package com.atguigu.web_bookstore.dao.impl;

import com.atguigu.web_bookstore.bean.User;
import com.atguigu.web_bookstore.dao.UserDao;
/*
 * users表操作的dao实现类
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public User getByName(String username) {
		String sql = "select * from users where username=?";
		return query(sql, username);
	}

	@Override
	public void insert(User user) {
		String sql = "insert into users values(?,?,?,?)";
		update(sql, user.getId(), user.getUsername(), user.getPassword(), user.getEmail());
	}

	@Override
	public User getByNameAndPwd(String username, String password) {
		String sql = "select * from users where username=? and password=?";
		return query(sql, username, password);
	}

	@Override
	public User getById(String id) {
		String sql = "select * from users where id=?";
		return query(sql, id);
	}
}
