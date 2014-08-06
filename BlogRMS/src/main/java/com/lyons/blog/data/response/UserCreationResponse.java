package com.lyons.blog.data.response;

import com.lyons.blog.data.User;

public class UserCreationResponse extends StatusResponse{
	
	public UserCreationResponse(boolean success, User user){
		super(success, "Successfully created user");
	}

}
