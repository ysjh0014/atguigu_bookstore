package com.atguigu.web_bookstore.dao.impl;

import java.util.List;

import com.atguigu.web_bookstore.bean.Address;
import com.atguigu.web_bookstore.dao.AddressDao;

/*
 * Address表操作的dao实现类
 */
public class AddressDaoImpl extends BaseDao<Address> implements AddressDao {

	@Override
	public void insert(Address address) {
		String sql = "insert into address values(?,?,?,?,?)";
		update(sql, address.getId(), address.getName(), address.getLocation(), address.getCellphone(),
				address.getUsersid());
	}

	@Override
	public List<Address> getListByUserId(String userid) {
		String sql = "select * from address where usersid=?";
		return queryForList(sql, userid);
	}

	@Override
	public Address getById(String addressid) {
		String sql = "select * from address where id=?";
		return query(sql, addressid);
	}

}
