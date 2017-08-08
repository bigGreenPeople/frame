package com.fj.domain;

public class User {
	private String username;
	private String password;
	private Integer tel;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, Integer tel) {
		super();
		this.username = username;
		this.password = password;
		this.tel = tel;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getTel() {
		return tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	
	
}
