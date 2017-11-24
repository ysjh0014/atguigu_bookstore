CREATE DATABASE bookstore;
USE bookstore;
#users 用户表
CREATE TABLE users
(
	id VARCHAR(40) PRIMARY KEY, #主键
	username VARCHAR(20) UNIQUE, #用户名
	PASSWORD VARCHAR(30), #密码
	email VARCHAR(40) #邮箱
);