package cn.java.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ELServlet")
public class ELServlet extends HttpServlet {
	
	private static final long SerialVersionUID=1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、首先获取username和age属性
		String username=request.getParameter("username");
		String age=request.getParameter("age");
		//2、将获取的数据保存到request域中
		request.setAttribute("username", username);
		request.setAttribute("age", age);
		//3、跳转到2.jsp页面，我们通过EL表达式来取出request域中的数据
		request.getRequestDispatcher("/2.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		
	}
}
