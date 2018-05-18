package com.iexport.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.iexport.dto.ImportExcelParamDto;
import com.iexport.dto.ImportExcelResultDto;
import com.iexport.dto.ParamDto;
import com.iexport.service.ExcelService;
import com.iexport.utils.RequestUtil;

/**
 * Servlet implementation class ImportExcelServlet
 */
public class ImportExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImportExcelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(ServletFileUpload.isMultipartContent(request)) {
			ParamDto dto = RequestUtil.parseParam(request);
			ImportExcelParamDto importExcelParamDto  = new ImportExcelParamDto();
			importExcelParamDto.setTitle(dto.getParamMap().get("title"));
			importExcelParamDto.setExcel(dto.getFileMap().get("excel"));
			ImportExcelResultDto importExcelResultDto = ExcelService.imp(importExcelParamDto);
			request.setAttribute("result",importExcelResultDto);
		}else {
			
		}
		request.getRequestDispatcher("/WEB-INF/jsp/importExcelResult.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
