package com.coursemanage.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.coursemanage.domain.Course;

public class CourseDao {
	/**用户登录 */
	public int login(String username, String password) {
		return 0;
	}
	/**普通管理员添加方法 */
	public void addUser(String username, String password) {
		
	}
	/**查询所有管理员*/
	public List<Map<String, Object>> getAllUsers(){
		return null;
	}
	/**删除管理员*/
	public void delUser(String username) {
		
	}
	
	/**添加课程*/
	public void addCourse(Course couse) {
		
	}
	
	/**查询所有课程信息*/
	public List<Course> getAllCourse(){
		return null;
	}
	
	/**批量导入Excel课程表数据*/
	public void importCourse(ArrayList<ArrayList<String>> courseList){
		
	} 
}
