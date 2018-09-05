package com.lyd.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyd.boot.pojo.User;
import com.lyd.boot.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/get")
	@ResponseBody
	public List<User> getAllUsers(){
		
		return userService.queryAllUsers();
	}
}
