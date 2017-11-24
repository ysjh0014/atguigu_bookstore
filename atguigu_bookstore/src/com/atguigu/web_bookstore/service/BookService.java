package com.atguigu.web_bookstore.service;

import java.util.List;

import com.atguigu.web_bookstore.bean.Book;
import com.atguigu.web_bookstore.bean.ConditionBook;
import com.atguigu.web_bookstore.bean.Page;
/*
 * 图书相关操作的业务接口
 */
public interface BookService {

	/**
	 * 添加一本书
	 * @param book
	 */
	public void addBook(Book book);
	/**
	 * 得到所有的书
	 * @return
	 */
	public List<Book> getAllBooks();
	/**
	 * 得到对应的一本书
	 * @param id
	 * @return
	 */
	public Book getBookById(String id);
	/**
	 * 删除对应的一本书
	 * @param id
	 */
	public void deleteBookById(String id);
	/**
	 * 更新对应的一本书
	 * @param book
	 */
	public void updateBook(Book book);

	/**
	 * 得到分页对象
	 * @param conditionBook
	 * @return
	 */
	public Page<Book> getPage(ConditionBook conditionBook);

}
