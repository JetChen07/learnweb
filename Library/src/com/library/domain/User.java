package com.library.domain;

public class User {
	private String userName;
	private String password;
	private String phone;
	private String email;
	public User() {
		super();
	}
	public User(String userName, String password, String phone, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.email = email; 
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", phone=" + phone + ", email=" + email + "]";
	}
}
