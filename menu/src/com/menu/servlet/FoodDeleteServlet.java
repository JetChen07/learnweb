package com.menu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.menu.domain.*;
/**
 * Servlet implementation class FoodDeleteServlet
 */
public class FoodDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = (String) request.getParameter("id");
		System.out.println(" 获得的id："+id);
		List<Dish> list = (List<Dish>) this.getServletContext().getAttribute("list");
		System.out.println("11");
		if(list!=null) {
			System.out.println("12");
			for(Dish d: list) {
				System.out.println(d.getId()+id);
				if(d.getId().equals(id)) {
					System.out.println("找到删除相");
					request.setAttribute("msg", "删除成功");
					list.remove(d);
					this.getServletContext().setAttribute("list",list);
					for(Dish d1:list) {
			        	System.out.println(d1);
			        }
					System.out.println("1122"+request.getAttribute("msg"));
					request.getRequestDispatcher("/deleteById.jsp").forward(request, response);
					return;
				}else {
					request.setAttribute("msg", "该id不存在");
					
				}
			}
			System.out.println("112222444");
			request.getRequestDispatcher("/deleteById.jsp").forward(request, response);
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
