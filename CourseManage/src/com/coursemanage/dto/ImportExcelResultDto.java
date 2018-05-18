package com.coursemanage.dto;

import org.apache.commons.fileupload.FileItem;

import com.coursemanage.domain.Course;


import java.util.List;

public class ImportExcelResultDto {
    private List<Course> courseList;
    private String msg;


  

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
}
