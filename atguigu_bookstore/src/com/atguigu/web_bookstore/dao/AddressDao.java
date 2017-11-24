package com.atguigu.web_bookstore.dao;

import java.util.List;

import com.atguigu.web_bookstore.bean.Address;
/*
 * address表操作的dao接口
 */
public interface AddressDao {

	/**
	 * 插入一条数据
	 * @param address
	 */
	public void insert(Address address);

	/**
	 * 根据用户id得到对应的所有地址的列表
	 * @param userid
	 * @return
	 */
	public List<Address> getListByUserId(String userid);

	/**
	 * 根据id得到对应的记录对象
	 * @param addressid
	 * @return
	 */
	public Address getById(String addressid);
	
}
