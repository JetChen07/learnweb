package cn.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class musicList
 */
@WebServlet("/musicListServlet")
public class musicListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String command = request.getParameter("command");
		System.out.println("command:"+command);
		JSONObject jsonObject = new JSONObject();
		if("lx".equals(command)){
			jsonObject.put("first", "����");
			jsonObject.put("second", "����");
			jsonObject.put("third", "�������");
		}else if("jd".equals(command)) {
			jsonObject.put("first", "ǧǧ�ڸ�");
			jsonObject.put("second", "ɵŮ");
			jsonObject.put("third", "����");
		}else if ("yg".equals(command)) {
			jsonObject.put("first", "һ��첼");
			jsonObject.put("second", "����ɮ");
			jsonObject.put("third", "�³���·�ϵ�ҡ��");
		}
		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
