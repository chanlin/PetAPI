package com.chanlin.pet.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chanlin.pet.model.User;
import com.chanlin.pet.service.UserServiceI;

@Controller
@RequestMapping("/userController")
public class UserController {
	private UserServiceI userService;

	public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}
	@RequestMapping("/login")
	@ResponseBody
	public User login(HttpServletRequest request){
		User user = userService.login();
		
		return user;
	}
	
}
