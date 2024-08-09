package com.nebula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nebula.dao.UserDao;
import com.nebula.entity.User;
import com.nebula.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping("/")
	public String helloMvc() {
		
		return "hello";
	}
//
//	@RequestMapping("/greet/{name}")
//	public String greet(@PathVariable("name") String name) {
//		
//		System.out.println(name);
//		return "greet";
//	}
	
	
	
	@PostMapping("/register")
	public ModelAndView register(@ModelAttribute User user) {
		ModelAndView view =new ModelAndView();
		service.registerUser(user);
		view.setViewName("registersuccess");
		return view;		
	}

}
