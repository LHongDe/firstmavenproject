package com.doak.firstmvnprj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doak.firstmvnprj.listener.MyListener;
import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.sun.javafx.binding.SelectBinding.AsDouble;
import com.sun.javafx.collections.MappingChange.Map;

@Controller
public class HelloController {

	
	@GetMapping(value="/asd/{name}")
	public String asDouble(@PathVariable String name) {
		System.out.println("inter asDouble");
		System.out.println("***************** name == " + name);
		return "success";
	}
	
	
	
	@RequestMapping(value="/login")
	public String login() {
		System.out.println("inter  login");
		return "login";
	}
	
	@RequestMapping(value = "/index")
	@ResponseBody
	public String index(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.setAttribute("fdf", "fdf");
		return "success";
	}
	
	@RequestMapping(value ="/online")
	@ResponseBody
	public Object online() {
		return "当前登陆人数：：" + MyListener.online;
	}
	
}
