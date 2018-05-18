package com.coursemanage.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.coursemanage.domain.Course;
import com.coursemanage.dto.ImportExcelParamDto;
import com.coursemanage.dto.ImportExcelResultDto;
import com.coursemanage.dto.ParamDto;
import com.coursemanage.service.CourseService;
import com.coursemanage.service.ExcelService;
import com.coursemanage.utils.ExcelHelper;


/**
 * Servlet implementation class CourseImportServlet
 */
@WebServlet("/CourseImportServlet")
public class CourseImportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseImportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(ServletFileUpload.isMultipartContent(request)) {
			ParamDto dto = ExcelHelper.parseParam(request);
			ImportExcelParamDto importExcelParamDto  = new ImportExcelParamDto();
			importExcelParamDto.setExcel(dto.getFileMap().get("file1"));
			ImportExcelResultDto importExcelResultDto = ExcelService.imp(importExcelParamDto);
			CourseService cService = new CourseService();
			/*for(Course course:importExcelResultDto.getCourseList()) {
				cService.getAllCourse().add(course);
			}*/
			cService.getAllCourse().addAll(importExcelResultDto.getCourseList());
			response.sendRedirect(request.getContextPath()+"/GetCourseServlet");
		}else {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
