package com.lyons.blog.tests;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.lyons.blog.controller.UsersController;

public class UsersControllerTest {
	
	MockMvc mockMvc;
	
	@InjectMocks
	UsersController usersController;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(usersController)
				.setMessageConverters(new MappingJackson2HttpMessageConverter())
				.build();
	}
}
