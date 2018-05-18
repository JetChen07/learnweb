package com.coursemanage.domain;

public class Course {
	private String id;
	private String name;
	private String direction;
	private String description;
	private String time;
	private String operator;
	
	public Course() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Course(String id, String name, String direction, String description, String time, String operator) {
		super();
		this.id = id;
		this.name = name;
		this.direction = direction;
		this.description = description;
		this.time = time;
		this.operator = operator;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
}
