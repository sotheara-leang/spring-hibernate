package com.mcnc.springhibernatelog4j;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mcnc.springhibernatelog4j.domain.User;
import com.mcnc.springhibernatelog4j.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:com/mcnc/springhibernatelog4j/spring/root-context.xml")
public class Log4j2Test {
	
	private static final Logger LOG = LoggerFactory.getLogger(Log4j2Test.class);
	
	@Autowired
	private UserService userService;
	
	@Test
	public void doTest() {
		LOG.info("Start logic");
		
		LOG.info("Create a user");
		User user = new User();
		user.setUsername("user-" + UUID.randomUUID());
		userService.create(user);
		LOG.debug("End creating a user");
		
		LOG.debug("Update a user");
		user.setUsername("user-" + UUID.randomUUID());
		userService.update(user);
		LOG.debug("End updating the user");
		
		LOG.debug("Query all user");
		List<User> users = userService.findAll();
		for (User u : users) {
			LOG.debug("User : {}", u);
		}
		LOG.debug("End query all user");
		
		LOG.debug("Delete a user");
		userService.delete(user);
		LOG.debug("End deleting the user");
		
		LOG.debug("Show an error");
		LOG.error("Simple error", new NullPointerException());
		
		LOG.debug("End logic");
	}
}
