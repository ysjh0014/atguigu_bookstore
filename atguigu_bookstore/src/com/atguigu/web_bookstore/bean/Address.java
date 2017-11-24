package com.atguigu.web_bookstore.bean;

/*
 #address 地址表
 create table address
 (
 id varchar(40) primary key,#主键
 name varchar(20),#收货人姓名
 location varchar(100),#地址
 cellphone varchar(20),#电话
 usersid varchar(40),#所对应用户的id
 constraint usersid_FK foreign key(usersid) references users(id)
 );
 */
public class Address {

	private String id;
	private String name;
	private String location;
	private String cellphone;
	private String usersid;

	public Address(String id, String name, String location, String cellphone,
			String usersid) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.cellphone = cellphone;
		this.usersid = usersid;
	}

	public Address() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getUsersid() {
		return usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", location="
				+ location + ", cellphone=" + cellphone + ", usersid=" + usersid
				+ "]";
	}
}
