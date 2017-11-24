#users 用户表
CREATE TABLE users
(
	id VARCHAR(40) PRIMARY KEY, #主键
	username VARCHAR(20) UNIQUE, #用户名
	PASSWORD VARCHAR(30), #密码
	email VARCHAR(40) #邮箱
);

#categorys 分类表 
CREATE TABLE categorys
(
	id VARCHAR(40) PRIMARY KEY, #主键
	NAME VARCHAR(30) #分类名称
);

#books 图书表
CREATE TABLE books 
(
	id VARCHAR(40) PRIMARY KEY , #主键
	NAME VARCHAR(50), #书名
	author VARCHAR(20), #作者
	price FLOAT, #价格
	salesamount INT(11) NOT NULL DEFAULT 0,#已售数量
  	storenumber INT(11) NOT NULL, #库存数量
	imagepath VARCHAR(100), #图书照片存储路径
	categorysid VARCHAR(40), #此图书对应的分类ID(是一个外键)
	CONSTRAINT categorysid_FK FOREIGN KEY(categorysid) REFERENCES categorys(id)
);

#address 地址表
CREATE TABLE address
(
	id VARCHAR(40) PRIMARY KEY,#主键
	NAME VARCHAR(20),#收货人姓名
	location VARCHAR(100),#地址
	cellphone VARCHAR(20),#电话
	usersid VARCHAR(40),#所对应用户的id
	CONSTRAINT usersid_FK FOREIGN KEY(usersid) REFERENCES users(id)
);

#orders 订单表
CREATE TABLE orders 
(
	id VARCHAR(40) PRIMARY KEY, #主键
	number VARCHAR(50),#订单号
	STATUS BOOLEAN DEFAULT FALSE,#状态, 标识是否发货
	price FLOAT,#价格
	ordertime TIMESTAMP,#下单时间
	usersid VARCHAR(40),#对应用户的ID
	addressid VARCHAR(40),#对应的地址ID
	CONSTRAINT usersid_FK1 FOREIGN KEY(usersid) REFERENCES users(id),
	CONSTRAINT addressid_FK FOREIGN KEY(addressid) REFERENCES address(id)
);

# orderitems 订单项
CREATE TABLE orderitems
(
	id VARCHAR(40) PRIMARY KEY,#主键
	quantity INT,#数量
	price FLOAT,#单价
	ordersid VARCHAR(40),#对应订单的ID
	booksid VARCHAR(40),#对应书的ID
	CONSTRAINT ordersid_FK FOREIGN KEY(ordersid) REFERENCES orders(id),
	CONSTRAINT booksid_FK FOREIGN KEY(booksid) REFERENCES books(id)
);