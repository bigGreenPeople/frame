package com.fj.domain;

public class User {
	private Integer uid;
	private String uname;
	private String usex;
	private Integer uage;
	private String utel;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public Integer getUage() {
		return uage;
	}
	public void setUage(Integer uage) {
		this.uage = uage;
	}
	public String getUtel() {
		return utel;
	}
	public void setUtel(String utel) {
		this.utel = utel;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return uid+"  "+uname+"  "+usex+"  "+uage+"  "+utel+"  ";
	}
}
