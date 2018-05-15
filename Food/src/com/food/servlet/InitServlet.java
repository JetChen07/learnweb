package com.food.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.dao.FoodDaoImpl;
import com.food.domain.Food;



/**
 * Servlet implementation class initServlet
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() throws ServletException {
        // TODO Auto-generated constructor stub
        FoodDaoImpl foodDaoImpl = new FoodDaoImpl();
		// 将list保存到ServletContext作用域中:
        Food food = new Food("1", "��������", "��", null, "5","�ó�");
        Food food2 = new Food("2", "10", "��dd", null, "58","�ó�");
        foodDaoImpl.addFood(food);
        foodDaoImpl.addFood(food2);
    }


}