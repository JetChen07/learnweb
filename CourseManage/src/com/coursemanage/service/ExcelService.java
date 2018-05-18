package com.coursemanage.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.coursemanage.domain.Course;
import com.coursemanage.dto.*;



public class ExcelService {
	public static ImportExcelResultDto imp(ImportExcelParamDto dto) {
		ImportExcelResultDto result = new ImportExcelResultDto();
		Workbook workbook =null;
		try {
			workbook = WorkbookFactory.create(dto.getExcel().getInputStream());
			Sheet sheet = workbook.getSheetAt(0);
			int rowNum = sheet.getLastRowNum();
			List<Course> courseList = new ArrayList<Course>();
			for(int i =1;i<=rowNum;i++) {
				Row row = sheet.getRow(i);
				Course course = new Course(row.getCell(0).getStringCellValue(),row.getCell(1).getStringCellValue(),row.getCell(2).getStringCellValue(),
						row.getCell(3).getStringCellValue(),row.getCell(4).getStringCellValue(),row.getCell(5).getStringCellValue());
				courseList.add(course);
			}
			result.setCourseList(courseList);
		}catch(Exception e) {
			e.printStackTrace();
			result.setMsg("Excel解析失败");
		}finally {
            if(workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
	}
	
	public Workbook export(boolean isXlsx) {
        Workbook workbook;
        if(isXlsx) {
            workbook = new XSSFWorkbook();
        } else {
            workbook = new HSSFWorkbook();
        }
        Sheet sheet = workbook.createSheet("My Sheet");
        CourseService cService = new CourseService();
        List<Course> courseList = cService.getAllCourse();
        int i = 0;
        for(Course course : courseList) {
            Row row = sheet.createRow(i);
            row.createCell(0).setCellValue(course.getId());
            row.createCell(1).setCellValue(course.getName());
            row.createCell(2).setCellValue(course.getDirection());
            row.createCell(3).setCellValue(course.getDescription());
            row.createCell(4).setCellValue(course.getTime());
            row.createCell(5).setCellValue(course.getOperator());
            i++;
            
        }
        return workbook;
    }

   
}
