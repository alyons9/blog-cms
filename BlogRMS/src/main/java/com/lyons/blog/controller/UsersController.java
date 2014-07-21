package com.lyons.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyons.blog.data.User;
import com.lyons.blog.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UsersController {
	
	@Autowired 
	private UserService userService;
	
	@RequestMapping(value = "/{key}", method = RequestMethod.GET)
	@ResponseBody public User getUser(@PathVariable(value = "key") int key){
		
		return userService.getUser(key);
	}

}
