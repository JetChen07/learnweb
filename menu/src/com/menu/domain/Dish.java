package com.menu.domain;

public class Dish {
	private String id;
	private String name;
	private String taste;
	private String path;
	private String price;
	private String describe;
	@Override
	public String toString() {
		return "Dish [id=" + id + ", name=" + name + ", taste=" + taste + ", path=" + path + ", price=" + price
				+ ", describe=" + describe + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Dish() {
		super();
	}
	public Dish(String id, String name, String taste, String path, String price, String describe) {
		super();
		this.id = id;
		this.name = name;
		this.taste = taste;
		this.path = path;
		this.price = price;
		this.describe = describe;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}

	
	
}
