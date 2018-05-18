package com.coursemanage.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coursemanage.domain.Course;
import com.coursemanage.service.CourseService;

/**
 * Servlet implementation class AddUserServlet
 */
public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String courseId = request.getParameter("courseId");    	
    	String courseName = request.getParameter("courseName");
    	String courseType = request.getParameter("courseType");
    	String description = request.getParameter("description");
    	String courseTime = request.getParameter("courseTime");
    	String operator = request.getParameter("operator");
    	Course course = new Course(courseId,courseName,courseType,description,courseTime,operator);
    	CourseService cService = new CourseService();
    	cService.addCourse(course);
        response.sendRedirect(request.getContextPath()+"/GetCourseServlet");
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
