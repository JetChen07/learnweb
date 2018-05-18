package com.coursemanage.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AuthFilter
 */
public class AuthFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest hrequest = (HttpServletRequest) request;// �漰��HTTP������ת�ʹ���
		HttpServletResponse hresponse = (HttpServletResponse) response;// �漰��HTTP������ת�ʹ���

		String loginUser = (String) hrequest.getSession().getAttribute("loginUser");// �ж��û��Ƿ�����˵�¼������session���Ƿ�洢�û���

		if (loginUser == null) {
			hresponse.sendRedirect(hrequest.getContextPath() + "/index.jsp?flag=1");// δ��¼��ϵͳǿ���ض�������¼ҳ��
			return;
		} else {
			chain.doFilter(hrequest, hresponse);
			return;
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
