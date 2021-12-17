package com.sist.filter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

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
 * Servlet Filter implementation class LogFilter
 */
@WebFilter("/LogFilter")
public class LogFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LogFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		//,true:�̹� �ִ� ���Ͽ� �߰��ϱ�
		FileWriter fw = new FileWriter("c:/sist/log.text",true);
		
		String cmd =((HttpServletRequest)request).getRequestURI();
		Date toDate = new Date();
		int year = toDate.getYear()+1900;
		int month = toDate.getMonth()+1;
		int date = toDate.getDate();
		int hours= toDate.getHours();
		int mintus=toDate.getMinutes();
		int seconds= toDate.getSeconds();
		String ip =request.getRemoteAddr();
		String time = year+"/"+month+"/"+date+""+
		hours+":"+mintus;
		
		
		long start = System.currentTimeMillis();		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		long end = System.currentTimeMillis();
		 
		
		System.out.println("��û ���񽺸�"+cmd);
		System.out.println("��û �ð�"+time);
		System.out.println("ip:"+ip);
		System.out.println("�ɸ��ð�:"+(end-start));
		System.out.println("======");
		
		fw.write("��û ���񽺸�"+cmd+"\n");
		fw.write("��û �ð�"+time+"\n");
		fw.write("ip:"+ip+"\n");
		fw.write("�ɸ��ð�:"+(end-start)+"\n");
		
	 
		fw.close();
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
