package com.menu.servlet;

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

import com.menu.domain.Dish;
import com.menu.utils.UploadUtils;


/**
 * Servlet implementation class addFoodServlet
 */
@WebServlet("/addFoodServlet")
public class addFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addFoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
						String path = this.getServletContext().getRealPath("/upload");
						// ���������Խӵ�������Ϳ�����:
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
			}
			List<Dish> dishes = (List<Dish>)this.getServletContext().getAttribute("list");
	        if(dishes!=null) {
		        for(Dish d:dishes) {
		        	if(d.getName().equals(map.get("foodName"))) {
			        	request.setAttribute("msg", "��Ʒ�Ѵ��ڣ�");
						request.getRequestDispatcher("/addFood.jsp").forward(request, response);
						return ;
		        	}
		        }
	        }
	        Dish dish = new Dish();
	        dish.setDescribe(map.get("id"));
	        dish.setId(map.get("id"));
	        dish.setName(map.get("foodName"));
	        dish.setPath(url);
	        dish.setPrice(map.get("price"));
	        dish.setTaste(map.get("taste"));
	        if(dishes!=null) {
		        dishes.add(dish);
		        for(Dish d:dishes) {
		        	System.out.println(d);
		        }
	        }else {
	        	dishes = new ArrayList<Dish>();
	        }
	        this.getServletContext().setAttribute("list", dishes);
	        request.setAttribute("msg","���ӳɹ�");
			response.sendRedirect(request.getContextPath()+"/addFood.jsp");
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