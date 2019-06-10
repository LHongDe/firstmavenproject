package com.doak.firstmvnprj.interceptor;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;




public class MyInterceptor implements HandlerInterceptor{


	public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("inter  preHandle");
		Map map = (Map)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		System.out.println(map.get("name"));
		System.out.println("MyInterceptor: " + request.getParameter("username"));
		if(map!=null&&"zhanyiqun".equals(map.get("name"))) {
			return true;
		}else {
			PrintWriter  printWriter = response.getWriter();
			printWriter.write("please login again!!");
			return false;
		}

	}
}
