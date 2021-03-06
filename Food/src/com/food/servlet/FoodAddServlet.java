package com.food.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.food.dao.FoodDaoImpl;
import com.food.domain.Food;
import com.food.utils.UploadUtils;


/**
 * Servlet implementation class addFoodServlet
 */
public class FoodAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Map<String,String> map = UploadUtils.UploadFile(request, this.getServletContext().getRealPath("/upload"));
			/*Map<String,String> map = new HashMap<String,String>();
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			// 2.创建一个核心解析类
			ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
			// 3.解析request请求，返回的是List集合，List集合中存放的是FileItem对象
			List<FileItem> list = servletFileUpload.parseRequest(request);
			// 定义一个List集合，用于保存兴趣爱好数据:
			// 4.遍历集合，获得每个FileItem，判断是表单项还是文件上传项
			String url = null;
			for (FileItem fileItem : list) {
				// 判断是表单项还是文件上传项
				if(fileItem.isFormField()){
					// 普通表单项:
					// 接收表单项参数的值:
					String name = fileItem.getFieldName(); // 获得表单项的name属性的值
					String value = fileItem.getString("UTF-8");// 获得表单项的值
					map.put(name, value);
				}else{
					// 文件上传项:
					// 文件上传功能：
					// 获得文件上传的名称：
					String fileName = fileItem.getName();
					if(fileName !=null && !"".equals(fileName)){
						// 通过工具类获得唯一文件名:
						String uuidFileName = UploadUtils.getUUIDFileName(fileName);
						// 获得文件上传的数据：
						InputStream is = fileItem.getInputStream();
						// 获得文件上传的路径:
						String path = this.getServletContext().getRealPath("/upload");
						// 将输入流对接到输出流就可以了:
						url = path+"\\"+uuidFileName;
						OutputStream os = new FileOutputStream(url);
						int len = 0;
						byte[] b = new byte[1024];
						while((len = is.read(b))!=-1){
							os.write(b, 0, len);
						}
						is.close();
						os.close();
					}
				}
			}*/
			FoodDaoImpl foodDaoImpl = new FoodDaoImpl();
			List<Food> foodlist = foodDaoImpl.getAllFood();
	        if(foodlist!=null) {
		        for(Food d:foodlist) {
		        	if(d.getName().equals(map.get("foodName"))) {
			        	request.setAttribute("msg", "菜品已存在！");
						request.getRequestDispatcher("/addFood.jsp").forward(request, response);
						return ;
		        	}
		        }
	        }
	        Food food = new Food();
	        food.setDescribe(map.get("id"));
	        food.setId(map.get("id"));
	        food.setName(map.get("foodName"));
	        food.setPath(map.get("path"));
	        food.setPrice(map.get("price"));
	        food.setTaste(map.get("taste"));
	        foodDaoImpl.addFood(food);
	        
	        foodDaoImpl.showAllFood();
	        request.setAttribute("msg","添加成功");
	        request.getRequestDispatcher("/addFood.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
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
