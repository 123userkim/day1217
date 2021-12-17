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
		
		//,true:이미 있는 파일에 추가하기
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
		 
		
		System.out.println("요청 서비스명"+cmd);
		System.out.println("요청 시간"+time);
		System.out.println("ip:"+ip);
		System.out.println("걸린시간:"+(end-start));
		System.out.println("======");
		
		fw.write("요청 서비스명"+cmd+"\n");
		fw.write("요청 시간"+time+"\n");
		fw.write("ip:"+ip+"\n");
		fw.write("걸린시간:"+(end-start)+"\n");
		
	 
		fw.close();
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
