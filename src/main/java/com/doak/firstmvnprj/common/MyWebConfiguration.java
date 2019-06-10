package com.doak.firstmvnprj.common;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.doak.firstmvnprj.filter.LoginFilter;
import com.doak.firstmvnprj.interceptor.MyInterceptor;
import com.doak.firstmvnprj.listener.MyListener;

@Configuration
public class MyWebConfiguration implements WebMvcConfigurer{

	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/login");
	}
	
	
	
	
	
	@Bean
	public FilterRegistrationBean  filterRegister() {
		FilterRegistrationBean filterBean = new FilterRegistrationBean();
		filterBean.setFilter(new LoginFilter());
		filterBean.addUrlPatterns("/*");
		return filterBean;
	}
	
	@Bean
	public ServletListenerRegistrationBean registrationBean() {
		ServletListenerRegistrationBean  registrationBean  = new ServletListenerRegistrationBean();
		registrationBean.setListener(new MyListener());
		System.out.println("");
		return registrationBean;
	}

}
