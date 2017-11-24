package com.atguigu.web_bookstore.dao;

import java.util.List;

import com.atguigu.web_bookstore.bean.Book;
/**
 * books表操作的dao接口
 * @author xfzhang
 *
 */
public interface BookDao {

	/**
	 * 插入一条数据
	 * @param book
	 */
	public void insert(Book book);
	/**
	 * 得到所有记录的集合
	 * @return
	 */
	public List<Book> getAll();
	
	/**
	 * 根据id得到对应的记录对象
	 * @param id
	 * @return
	 */
	public Book getById(String id);
	
	/**
	 * 更新某条记录
	 * @param book
	 */
	public void update(Book book);
	
	/**
	 * 删除对应的记录
	 * @param id
	 */
	public void deleteById(String id);

	/**
	 * 根据条件得到总记录数
	 * @param categorysid
	 * @param minprice
	 * @param maxPrice
	 * @return
	 */
	public long getTotalRecord(String categorysid, int minprice, int maxPrice);

	/**
	 * 根据条件得到满足条件的记录的集合
	 * @param categorysid
	 * @param minprice
	 * @param maxPrice
	 * @param start
	 * @param count
	 * @return
	 */
	public List<Book> getList(String categorysid, int minprice, int maxPrice, int start, int count);

	/**
	 * 根据categorysid判断有没有对应的记录
	 * @param categorysid
	 * @return
	 */
	public boolean hasBookByCategorysId(String categorysid);
	
	/**
	 * 批量更新书的数据
	 * @param data
	 */
	public void batchUpdateStoreAndSale(Object[][] data);
}
