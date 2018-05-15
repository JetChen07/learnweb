package com.food.utils;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 文件上传的工具类
 * @author jt
 *
 */
public class UploadUtils {

	/**
	 * 生成唯一的文件名:
	 */
	public static String getUUIDFileName(String fileName){
		// 将文件名的前面部分进行截取：xx.jpg   --->   .jpg
		int idx = fileName.lastIndexOf(".");
		String extention = fileName.substring(idx);
		String uuidFileName = UUID.randomUUID().toString().replace("-", "")+extention;
		return uuidFileName;
	}
	public static Map<String, String> UploadFile(HttpServletRequest request, String uploadDirectory) {
		try {
			Map<String,String> map = new HashMap<String,String>();
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			// 2.����һ�����Ľ�����
			ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
			// 3.����request���󣬷��ص���List���ϣ�List�����д�ŵ���FileItem����
			List<FileItem> list = servletFileUpload.parseRequest(request);
			// ����һ��List���ϣ����ڱ�����Ȥ��������:
			// 4.�������ϣ����ÿ��FileItem���ж��Ǳ�������ļ��ϴ���
			String url = null;
			for (FileItem fileItem : list) {
				// �ж��Ǳ�������ļ��ϴ���
				if(fileItem.isFormField()){
					// ��ͨ������:
					// ���ձ����������ֵ:
					String name = fileItem.getFieldName(); // ��ñ������name���Ե�ֵ
					String value = fileItem.getString("UTF-8");// ��ñ������ֵ
					map.put(name, value);
				}else{
					// �ļ��ϴ���:
					// �ļ��ϴ����ܣ�
					// ����ļ��ϴ������ƣ�
					String fileName = fileItem.getName();
					if(fileName !=null && !"".equals(fileName)){
						// ͨ����������Ψһ�ļ���:
						String uuidFileName = UploadUtils.getUUIDFileName(fileName);
						// ����ļ��ϴ������ݣ�
						InputStream is = fileItem.getInputStream();
						// ����ļ��ϴ���·��:
						// ���������Խӵ�������Ϳ�����:
						url = uploadDirectory+"\\"+uuidFileName;
						OutputStream os = new FileOutputStream(url);
						int len = 0;
						byte[] b = new byte[1024];
						while((len = is.read(b))!=-1){
							os.write(b, 0, len);
						}
						is.close();
						os.close();
						map.put("path", url);
					}
				}
			}		
			return map;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
/*	public static void main(String[] args) {
		System.out.println(getUUIDFileName("1.jpg"));
	}*/
}