package com.lyons.blog.tests.fixtures;

import java.util.Collections;
import java.util.List;

import com.lyons.blog.data.User;
import com.lyons.blog.data.response.StatusResponse;

public class UsersFixtures {
	public static StatusResponse userCreated(User user){
		return new StatusResponse(true, "Successfully created user with username: '" + user.getEmail() + "'");
	}
	
	public static StatusResponse userNotCreated(User user){
		return new StatusResponse(false, "Unable to create user");
	}
	
	public static StatusResponse userCreationFailure(User user){
		return new StatusResponse(false, "Unable to create user with username: '" + user.getEmail() + "'");
	}
	
	public static List<User> getUsers(){
		return Collections.singletonList(new User(1, "Anthony", "Lyons", "alyons@test.com", "alyons"));
	}
	
	public static User getUser(int key){
		return new User(key, "Anthony", "Lyons", "alyons@test.com", "alyons");
	}
	
	public static StatusResponse userDeleted(int  userKey){
		return new StatusResponse(true, "Successfully deleted user");
	}
}
