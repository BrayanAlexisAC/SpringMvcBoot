package com.company.springBootApp.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.springBootApp.objects.Users;
import com.company.springBootApp.repositoies.UsersRepository;

//@Controller  Usually we use RestControler not Controller for some parameters than use in RestController like @ResponseBody
@RestController
public class UsersController {
	
	@Autowired
	UsersRepository usersRepo;
	
//	we can specify form of answer with produces, in this case we use XML
	@GetMapping(path="getAllUsers", produces="application/json")
//	@ResponseBody
	public List<Users> getAllUsers() {
		int num = 9/0;
		return usersRepo.findAll();
	}
	
//	we use @PathVariable for variables separated with "/" or we use @PathParam for parameters 
//	@GetMapping("getOneUser/{userName}")
	@GetMapping("getOneUser")
//	@ResponseBody
	public Users getOneUser(@PathParam("userName") String userName) {
		return usersRepo.findByName(userName).orElse(new Users());
	}
	
	@PostMapping(path="addOneUser") 
	public String addOneUser(Users user) {
		String answer;
		
		if(user != null) {
			usersRepo.save(user);
			answer = "successful operation";
		} else {
			answer = "processing error";
		}
		return answer;
	}
	
//	we can specify form of parameters with consumes, in this case we use JSON
	@PostMapping(path="addOneUserJson", consumes=MediaType.APPLICATION_JSON_VALUE) 
	public String addOneUserJson(@RequestBody Users user) {
		String answer;
		
		if(user != null) {
			usersRepo.save(user);
			answer = "successful operation";
		} else {
			answer = "processing error";
		}
		return answer;
	}
	
	@GetMapping(path = "getGenericJson")
	public List<Map<String, String>> getGenericJson() {
		List<Map<String, String>> lst = new ArrayList<>();
		lst.add(new HashMap<>());
		lst.get(0).put("dato1", "dato1.1");
		lst.get(0).put("dato2", "dato1.2");
		lst.get(0).put("dato3", "dato1.3");
		lst.add(new HashMap<>());
		lst.get(1).put("dato1", "dato2.1");
		lst.get(1).put("dato2", "dato2.2");
		lst.get(1).put("dato3", "dato2.3");		
		
		return lst;
	}
	
}
