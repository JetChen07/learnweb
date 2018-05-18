package com.coursemanage.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.coursemanage.domain.Course;
import com.coursemanage.domain.User;

public class CourseDaoImpl {
	private static final List<User> usersTable = new ArrayList<User>();
    private static final List<Course> coursesTable = new ArrayList<Course>();
	public static List<User> getUserstable() {
		return usersTable;
	}
	public static List<Course> getCoursestable() {
		return coursesTable;
	}

}
