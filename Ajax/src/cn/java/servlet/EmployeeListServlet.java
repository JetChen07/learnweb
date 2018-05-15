package cn.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeList
 */
@WebServlet("/EmployeeListServlet")
public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		String data = "";
		if("1".equals(flag)){//Java课程
			data = "小明<br>小红<br>小白";
		}else if("2".equals(flag)){//C课程
			data = "职员<br>经理";
		}else if("3".equals(flag)) {
			data="人事部<br>技术部<br>无线部";
		}
		//3、将数据信息回写给ajax
		response.getOutputStream().write(data.getBytes("utf-8"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}