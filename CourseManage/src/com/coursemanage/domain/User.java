package com.coursemanage.domain;

public class User {
	public User(String name, String password, boolean manager) {
		super();
		this.name = name;
		this.password = password;
		this.manager = manager;
	}
	private String name;
	private String password;
	private boolean manager;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isManager() {
		return manager;
	}
	public void setManager(boolean manager) {
		this.manager = manager;
	}

}
