package com.food.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.dao.FoodDaoImpl;
import com.food.domain.Food;
/**
 * Servlet implementation class FoodDeleteServlet
 */
public class FoodDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = (String) request.getParameter("id");
		System.out.println(" ��õ�id��"+id);
		FoodDaoImpl foodDaoImpl = new FoodDaoImpl();
		List<Food> list = foodDaoImpl.getAllFood();
		System.out.println("11");
		if(list!=null&&id!=null) {
			System.out.println("12");
			if(foodDaoImpl.getFoodById(id)!=null) {
				foodDaoImpl.deleteFoodById(id);
				request.setAttribute("msg", "ɾ���ɹ�");
			}else {
				request.setAttribute("msg", "��id������");
			}
			
			/*for(Food d: list) {
				System.out.println(d.getId()+id);
				if(d.getId().equals(id)) {
					System.out.println("�ҵ�ɾ����");
					request.setAttribute("msg", "ɾ���ɹ�");
					
					this.getServletContext().setAttribute("list",list);
					for(Food d1:list) {
			        	System.out.println(d1);
			        }
					System.out.println("1122"+request.getAttribute("msg"));
					request.getRequestDispatcher("/deleteById.jsp").forward(request, response);
					return;
				}else {
					request.setAttribute("msg", "��id������");
					
				}
			}*/
			System.out.println("112222444");
			request.getRequestDispatcher("/deleteById.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "idΪ��");
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