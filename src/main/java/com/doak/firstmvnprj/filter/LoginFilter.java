package com.doak.firstmvnprj.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class LoginFilter implements Filter{

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("inter LoginFilter");
		HttpServletRequest htsr = (HttpServletRequest)request;
		HttpServletResponseWrapper hsrw = new HttpServletResponseWrapper((HttpServletResponse)response);
		
		if(htsr.getRequestURI().indexOf("/login") != -1||
				htsr.getRequestURI().indexOf("/register") != -1||
				htsr.getRequestURI().indexOf("/index") != -1||
				htsr.getRequestURI().indexOf("/online") != -1||
				htsr.getRequestURI().indexOf("/asd") != -1
				) {
			chain.doFilter(request, response);
		}else {
			System.out.println("重定向到登陆页面");
			hsrw.sendRedirect("/login");
		}
		
		
		
	}

}
