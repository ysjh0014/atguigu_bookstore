package com.atguigu.web_bookstore.dao.impl;

import java.util.List;

import com.atguigu.web_bookstore.bean.Category;
import com.atguigu.web_bookstore.dao.CategoryDao;
/*
 * categorys表数据操作的dao实现类
 */
public class CategoryDaoImpl extends BaseDao<Category> implements CategoryDao {

	@Override
	public Category getByName(String name) {
		String sql = "select * from categorys where name=?";
		return query(sql, name);
	}

	@Override
	public void insert(Category category) {
		String sql = "insert into categorys values(?,?)";
		update(sql, category.getId(), category.getName());
	}

	@Override
	public List<Category> getAll() {
		String sql = "select * from categorys";
		return queryForList(sql);
	}

	@Override
	public void update(Category category) {
		String sql = "update categorys set name=? where id=?";
		update(sql, category.getName(), category.getId());
	}

	@Override
	public void deleteById(String id) {
		String sql = "delete from categorys where id=?";
		update(sql, id);
	}

	@Override
	public Category getById(String id) {
		String sql = "select * from categorys where id=?";
		return query(sql, id);
	}

}
