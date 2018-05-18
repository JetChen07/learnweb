package com.iexport.utils;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.iexport.dto.ParamDto;

public class RequestUtil {
	public static ParamDto parseParam(HttpServletRequest request) {
		ParamDto result = new ParamDto();
		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
		upload.setHeaderEncoding("UTF-8");
		try {
			List<FileItem> fileItemList = upload.parseRequest(request);
			for(FileItem fileItem:fileItemList) {
				if(fileItem.isFormField()) {
					result.getParamMap().put(fileItem.getFieldName(), fileItem.getString());
				}else {
					result.getFileMap().put(fileItem.getFieldName(), fileItem);
					/*fileItem.write(new File("d:/upload/"+fileItem.getName()));*/
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
