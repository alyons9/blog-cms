package com.lyons.blog.service;

import java.util.List;

import com.lyons.blog.data.User;
import com.lyons.blog.data.response.StatusResponse;

public interface UserService {
//	public List<User> getAllUsers();
	public User getUser(int userKey);
	public StatusResponse createNewUser(User user);
	public StatusResponse updateUser(User user);
	public StatusResponse deleteUser(int userKey);
}
