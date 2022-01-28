package com.company.springBootApp.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.company.springBootApp.objects.Users;
import com.company.springBootApp.repositoies.UsersRepository;

@Controller
public class HomeController {
	
	@Autowired
	UsersRepository usersRepo;
	
	@ModelAttribute
	public void setAttributes(HttpServletRequest request, Model model, Users user) {
		HttpSession session = request.getSession();
		session.setAttribute("userName", user.getName());
	}
	
	@RequestMapping(path = "/")
	public String home() {
		return "index";
	}
	
	@RequestMapping(path = "getUser", method = RequestMethod.POST)
	public ModelAndView getUser(@ModelAttribute Users user) {
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println("User: " + user.getName());
		System.out.println("Password: " + user.getPass());
		
//		Users userBD = usersRepo.findAll().stream().filter(data -> data.getName().toUpperCase().equals(user.getName().toUpperCase())).findFirst().orElse(null);
		Users userBD = usersRepo.findByName(user.getName()).orElse(null) ;
		
		if (userBD != null && user.getPass().equals(userBD.getPass())) {
			modelAndView.addObject("user", user);
			modelAndView.setViewName("main");
		} else {
			modelAndView.addObject("msg", "Incorrect user or password, try it again");
			modelAndView.setViewName("index");
		}
		
		return modelAndView;
	}
	
	@PostMapping("addUser")
	public ModelAndView addUser(@ModelAttribute("user") Users user) {
		ModelAndView modelAndView = new ModelAndView();
		
		if(!usersRepo.existUserByName(user.getName())) {
			usersRepo.save(user);
			modelAndView.setViewName("index");
			modelAndView.addObject("msg", "You are Subscribed enjoy!");
		} else {
			modelAndView.setViewName("index");
			modelAndView.addObject("msg", "Missing subscribed you, User already exist, try again");
		}
		
		return modelAndView;
	}
}
