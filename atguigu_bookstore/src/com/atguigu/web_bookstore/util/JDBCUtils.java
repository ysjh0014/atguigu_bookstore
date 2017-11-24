package com.atguigu.web_bookstore.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.atguigu.web_bookstore.exception.DBException;
import com.mchange.v2.c3p0.ComboPooledDataSource;
/*
 * 数据库操作的工具类
 * 1. 得到连接对象
 * 2. 释放连接
 */
public final class JDBCUtils {

	private static ComboPooledDataSource dataSource = new ComboPooledDataSource("webDataSource");
	private static ThreadLocal<Connection> local = new ThreadLocal<Connection>();

	/**
	 * 1. 得到连接对象
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;

		try {
			conn = local.get();
			if(conn==null) {
				conn = dataSource.getConnection();
				local.set(conn);
			}
		} catch (SQLException e) {
			throw new DBException(e);
		}
		return conn;
	}
	
	/**
	 * 2. 释放连接
	 * @param conn
	 */
	public static void releaseConn(Connection conn) {

		if (conn != null) {
			try {
				local.remove();
				conn.close();
			} catch (SQLException e) {
				throw new DBException(e);
			}
		}
	}

}
