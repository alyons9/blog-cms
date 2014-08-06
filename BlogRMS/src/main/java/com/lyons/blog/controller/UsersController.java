package com.lyons.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyons.blog.data.User;
import com.lyons.blog.data.response.StatusResponse;
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
	
	@RequestMapping(value = "/{key}", method = RequestMethod.POST)
	@ResponseBody public StatusResponse addUser(@PathVariable(value = "key") int key,
												@RequestParam(value = "fn") String firstName,
												@RequestParam(value = "ln") String lastName,
												@RequestParam(value = "em") String email,
												@RequestParam(value = "un", required = false) String username){
		
		return userService.createNewUser(new User(key, firstName, lastName, email, username));	
	}
	
	@RequestMapping(value = "/{key}", method = RequestMethod.PUT)
	@ResponseBody public StatusResponse updateUser(@PathVariable(value = "key") int key,
													@RequestParam(value = "fn", required = true) String firstName,
													@RequestParam(value = "ln", required = true) String lastName,
													@RequestParam(value = "em", required = true) String email,
													@RequestParam(value = "un", required = false) String username){
		return userService.updateUser(new User(key, firstName, lastName, email,username));
	}
	
	@RequestMapping(value = "/{key}", method = RequestMethod.DELETE)
	@ResponseBody public StatusResponse deleteUser(@PathVariable(value = "key") int key){
		return userService.deleteUser(key);
	}

}
