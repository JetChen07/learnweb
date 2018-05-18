package com.coursemanage.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coursemanage.service.CourseService;

import java.io.IOException;
import java.io.PrintWriter;


public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	CourseService cService = new CourseService();
        //鑾峰彇娴忚鍣ㄨ緭鍑烘祦瀵硅薄
        PrintWriter out = response.getWriter();
        //鑾峰彇鐢ㄦ埛浼犻�掕繃鏉ョ殑楠岃瘉鐮�
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
        String code = request.getParameter("code");
        //鑾峰彇楠岃瘉鐮佹鏋朵骇鐢熺殑楠岃瘉鐮侊紙浼氳瘽涓瓨鍌ㄧ殑楠岃瘉鐮侊級
        String sessionCode = (String)request.getSession().getAttribute("kcode");
        request.getSession().setAttribute("loginUser", username);
        System.out.println(username+","+password+","+code);
       /* if(code!=null&sessionCode!=null) {
        	System.out.println("1");
            //濡傛灉鐢ㄦ埛杈撳叆鐨勯獙璇佺爜鍜屼骇鐢熷湪鏈嶅姟鍣ㄧ鐨勯獙璇佺爜涓�鑷达紝閭ｄ箞灏卞憡璇夌敤鎴疯緭鍏ユ纭�
            if (code.equalsIgnoreCase(sessionCode)) {*/
                //鐧诲綍閫昏緫銆佹敞鍐岄�昏緫绛夌浉鍏崇殑涓氬姟鎿嶄綔
            	int result = cService.login(username, password);
            	if(result == CourseService.SUCCESS) {
            		request.getSession().setAttribute("flag", "0");
            		response.sendRedirect(request.getContextPath()+"/jsp/server.jsp");
            		return;
            	}else if(result == CourseService.ManagerSUCCESS){
            		request.getSession().setAttribute("flag", "1");
            		response.sendRedirect(request.getContextPath()+"/jsp/server.jsp");
            		return;
            	}else {
            		response.sendRedirect(request.getContextPath() + "/index.jsp?flag=2");//账号密码失败
            		return;
            	}
           /* } else {
            	response.sendRedirect(request.getContextPath() + "/index.jsp?flag=3");//验证码失败
            	return;
            }
        }
        response.sendRedirect(request.getContextPath() + "/index.jsp?flag=3");//验证码失败
        return;*/

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
