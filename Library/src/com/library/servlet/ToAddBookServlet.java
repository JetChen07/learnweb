package com.library.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.dao.LibDaoImpl;
import com.library.domain.Catalog;

/**
 * Servlet implementation class ToAddBookServlet
 */
@WebServlet("/ToAddBookServlet")
public class ToAddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToAddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Catalog>cataList = LibDaoImpl.getInstance().getCatalogList();
		List<String> cataNames = new ArrayList<String> ();
		for(Catalog catalog: cataList) {
			cataNames.add(catalog.getName());
			System.out.println(catalog.getName());
		}
		request.setAttribute("cataNames", cataNames);
		request.getRequestDispatcher("/pages/admin/addBook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
