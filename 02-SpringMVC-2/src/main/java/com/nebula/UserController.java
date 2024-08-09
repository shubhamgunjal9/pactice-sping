package com.nebula;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nebula.entity.User;
import com.nebula.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping("/")
	public ModelAndView getHomePage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("home");
		return view;
	}
	
	@PostMapping("save")
	public String saveUser(@ModelAttribute User user) {
		System.out.println(user);
		service.save(user);
		return "regsuccess";
	}
	
	@GetMapping("success")
	public String getUsers(Model model) {
		List<User> all = service.getAll();
		model.addAttribute("all",all);
		return "success"; 
	}
	
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.deleteById(id);
		return "redirect:/success";
	}
	
	
	@RequestMapping("update/{id}")
	public String update(@PathVariable Integer id ,Model model) {
		User user = service.getById(id);
		model.addAttribute("user",user);
		return "update";
	}
	
	@PostMapping("update/save")
	public String update(@ModelAttribute User user) {
		service.update(user);
		return "regsuccess";
	}

}
