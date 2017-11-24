package com.atuigu.bookstore.dao.impl;

import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import com.atuigu.bookstore.domain.User;
import com.atuigu.bookstore.util.JDBCUtils;

/*
 进行的操作:DML DQL
 它要借用哪些类去完成功能?
 1. JDBCUtils
 2. dbutils.jar
 QueryRunner
 update(...)  //DML
 query(....)  //DQL
 ResultSetHandler(接口)
 BeanHandler  -->返回一个对象
 BeanListHandler --->返回一个对象的集合
 */
public abstract class BaseDao<T> {

	private QueryRunner runner = new QueryRunner();
	private Class<T> beanType;

	public BaseDao() {
		
		//BaseDao<User>
		ParameterizedTypeImpl genericSuperclass = (ParameterizedTypeImpl) this.getClass().getGenericSuperclass();
		//User的class对象
		beanType = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	
		/*Class clazz = this.getClass();
		//System.out.println(clazz);
	
		Type genericSuperType = clazz.getGenericSuperclass();
		System.out.println(genericSuperType);
		
		Class  genericSuperClass = genericSuperType.getClass();
		System.out.println(genericSuperClass);
		
		ParameterizedTypeImpl typeImpl = (ParameterizedTypeImpl) genericSuperType;
		Type type = typeImpl.getActualTypeArguments()[0];
		System.out.println(type);
		beanType = (Class<T>) type;*/
	}

	/*
	 * 对表数据进行增删改操作 CUD DML
	 */
	public void update(String sql, Object... params) {
		Connection conn = null;

		try {
			conn = JDBCUtils.getConnection();
			runner.update(conn, sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.releaseConn(conn);
		}
	}

	// R DQL
	public T query(String sql, Object... params) {
		T t = null;

		Connection conn = null;

		try {
			conn = JDBCUtils.getConnection();
			t = runner.query(conn, sql, new BeanHandler<T>(beanType), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.releaseConn(conn);
		}

		return t;
	}

	// R DQL
	public List<T> queryForList(String sql, Object... params) {
		List<T> list = new ArrayList<>();

		Connection conn = null;

		try {
			conn = JDBCUtils.getConnection();
			list = runner.query(conn, sql, new BeanListHandler<T>(beanType),
					params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.releaseConn(conn);
		}

		return list;
	}

}
