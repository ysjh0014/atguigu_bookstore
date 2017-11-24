package com.atguigu.web_bookstore.service.impl;

import java.util.List;

import com.atguigu.web_bookstore.bean.Category;
import com.atguigu.web_bookstore.dao.BookDao;
import com.atguigu.web_bookstore.dao.CategoryDao;
import com.atguigu.web_bookstore.dao.impl.CategoryDaoImpl;
import com.atguigu.web_bookstore.factory.BeanFactory;
import com.atguigu.web_bookstore.service.CategoryService;
/*
 * 图书分类的相关功能操作业务实现类
 */
public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categoryDao = BeanFactory.get(CategoryDao.class);
	
	@Override
	public boolean addCategory(Category category) {
		boolean success = false;
		Category dbCategory = categoryDao.getByName(category.getName());
		if(dbCategory==null) {
			categoryDao.insert(category);
			success = true;
		}
		return success;
	}

	@Override
	public List<Category> getAllCategorys() {
		
		return categoryDao.getAll();
	}

	@Override
	public void updateCategory(Category category) {
		categoryDao.update(category);
	}

	@Override
	public void deleteCategoryById(String id) {
		categoryDao.deleteById(id);
	}

	@Override
	public Category getCategory(String id) {
		return categoryDao.getById(id);
	}
}
