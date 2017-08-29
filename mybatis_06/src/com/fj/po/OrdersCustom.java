package com.fj.po;

import java.util.Date;

public class OrdersCustom extends Orders {
	private String username;// 用户姓名
	private String sex;// 性别
	private Date birthday;// 生日
	private String address;// 地址
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "OrdersCustom [username=" + username + ", sex=" + sex
				+ ", birthday=" + birthday + ", address=" + address
				+ ", getId()=" + getId() + ", getUser_id()=" + getUser_id()
				+ ", getNumber()=" + getNumber() + ", getCreatetime()="
				+ getCreatetime() + ", getNote()=" + getNote()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
