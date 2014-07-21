package com.lyons.blog.tests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static com.lyons.blog.tests.fixtures.UsersFixtures.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.lyons.blog.controller.UsersController;
import com.lyons.blog.data.User;
import com.lyons.blog.service.UserService;

public class UsersControllerTest {
	
	MockMvc mockMvc;
	
	@InjectMocks
	UsersController usersController;
	
	@Mock
	UserService userService;
	
	User user = new User(1, "Anthony", "Lyons", "alyons@test.com");

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(usersController)
				.setMessageConverters(new MappingJackson2HttpMessageConverter())
				.build();
	}
	
	@Test
	public void testGetUser(){
		when(userService.getUser(any(int.class))).thenReturn(getUser(2));
		
		try{
			mockMvc.perform(
					get("/user/{key}", 2)
					)
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.key").value(2));
		}catch(Exception e){
			
		}
	}
	
	@Test
	public void testUserCreatedSuccesfully(){
		when(userService.createNewUser(any(User.class))).thenReturn(userCreated(user));
		
		try {
			this.mockMvc.perform(
					post("/user?fn={fn}&ln={ln}&un={un}", user.getFirstName(), user.getLastName(), user.getEmail())
					.accept(MediaType.APPLICATION_JSON)
					)
					.andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUserUpdatedSuccessfully(){
		when(userService.updateUser(any(User.class))).thenReturn(userCreated(user));
		
		try{
			this.mockMvc.perform(
			put("/user/{key}?fn={fn}&ln={ln}&un={un}", user.getKey(), user.getFirstName(), user.getLastName(), user.getEmail()))
			.andExpect(status().isOk());
		}catch(Exception e){
			
		}
	}
	
	@Test
	public void testUsedDeletedSuccessfully(){
		when(userService.deleteUser(any(int.class))).thenReturn(userDeleted(user.getKey()));
		
		try{
			mockMvc.perform(
					delete("/user/{key}", user.getKey())
					.accept(MediaType.APPLICATION_JSON)
					)
					.andExpect(status().isOk());
		}catch(Exception e){
			
		}
	}
	
	
}
