package com.coursemanage.service;

import java.util.*;

import javax.servlet.http.HttpServletResponse;

import com.coursemanage.dao.CourseDaoImpl;
import com.coursemanage.domain.Course;
import com.coursemanage.domain.User;

public class CourseService {
	public final static int SUCCESS = 1;
	public final static int FAIL =2;
	public static final int ManagerSUCCESS = 3;
	
	/**
	 * �û���¼:
	 */
	public int login(String username, String password) {
		if(username==null||password==null) {
			return FAIL;
		}
		for(User user:CourseDaoImpl.getUserstable()) {
			if(user.getName().equals(username)){
				if(user.getPassword().equals(password)) {
					if(user.isManager()) {
						return ManagerSUCCESS;
					}else {
						return SUCCESS;
					}
				}			
			}
		}
		return FAIL;
	}

	/**
	 * ��ͨ����Ա��ӷ�����
	 */
	public void addUser(String username, String password,boolean isManager) {
		User user = new User(username,password,isManager);
		CourseDaoImpl.getUserstable().add(user);
	}

	/**
	 * ��ѯ���й���Ա��
	 */
	public List<User> getAllUsers(){
		
		return CourseDaoImpl.getUserstable();
	}

	/**
	 * ɾ������Ա
	 */
	public void delUser(String username) {
		if(username==null) {
			return;
		}else {
			for(User user:CourseDaoImpl.getUserstable()) {
				if(user.getName().equals(username)){
					CourseDaoImpl.getUserstable().remove(user);
					return;
				}
			}
		}
	}
	
	/**
	 * ��ӿγ̣�
	 */
	public void addCourse(Course course) {
		CourseDaoImpl.getCoursestable().add(course);
	}
	
	
	/**
	 * ��ѯ���пγ���Ϣ
	 */
	public List<Course> getAllCourse(){
		return CourseDaoImpl.getCoursestable();
	}
	
	
	/**
	 * ��������Excel�γ̱�����
	 */
	public void importCourse(ArrayList<ArrayList<String>> courseList) {
		
	}
	
	
	/**
	 * �γ̵�����
	 */
	public void exportCourse(HttpServletResponse response) {
		
	}
}
