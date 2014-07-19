package com.lyons.blog.service;

import java.util.List;

import com.lyons.blog.data.User;

public interface UserService {
	public List<User> getAllUsers();
	public String createNewUser();
	public String updateUser();
}
