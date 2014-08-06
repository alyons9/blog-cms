package com.lyons.blog.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.lyons.blog.config.JPAConfiguration;
import com.lyons.blog.data.User;
import com.lyons.blog.repository.UsersRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JPAConfiguration.class})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class UsersRepositoryIntegrationTest {
	@Autowired
	private UsersRepository usersRepository;
	
	@Test
	public void testUsersInserted(){
		User user = new User(1,"Test", "User", "test.user@gmail.com", "tuser");
		usersRepository.save(user);
		
		User user2 = usersRepository.findByKey(user.getKey());
		assertNotNull(user);
		assertEquals(user, user2);
	}
}
