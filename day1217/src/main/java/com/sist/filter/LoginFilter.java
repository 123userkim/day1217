package com.sist.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
//@WebFilter("/loginOK.jsp")
public class LoginFilter implements Filter {
	String admin_id;
	String admin_passwd;

    /**
     * Default constructor. 
     */
    public LoginFilter() {
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
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		if(id.equals("admin_id") && passwd.equals("admin_passwd")) {
			
			chain.doFilter(request, response);
		}else {			
			((HttpServletResponse)response).sendRedirect("login.jsp");
		}
		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		admin_id= fConfig.getInitParameter("admin_id");
		admin_passwd= fConfig.getInitParameter("admin_passwd");
	}
}

