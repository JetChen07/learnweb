package com.library.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.LibDaoImpl;
import com.library.domain.User;

/**
 * Servlet implementation class InitServlet
 */

public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitServlet() {
        super();
        User user = new User("jack","12345678","15205758619","525709017@qq.com");
        LibDaoImpl.getInstance().regist(user);
        LibDaoImpl.getInstance().addBookCatgory("1", "古典小说", "hahah");
        LibDaoImpl.getInstance().addBookCatgory("2", "武侠小说", "ssss");
        // TODO Auto-generated constructor stub
    }

	

}
