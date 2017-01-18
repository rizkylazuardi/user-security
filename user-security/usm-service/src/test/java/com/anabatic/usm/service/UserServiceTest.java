package com.anabatic.usm.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anabatic.usm.persistence.config.ConfigurationDatabase;
import com.anabatic.usm.service.api.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {AppConfig.class})
@ContextConfiguration(locations = {"classpath:applicationContext-service-test.xml",
		"classpath:applicationContext-persistence-test.xml"})
public class UserServiceTest {
	 @Autowired
	 @Qualifier("userService")
	 UserService userService;

	 @Autowired
	 ConfigurationDatabase confDb;
	 
	 @Test
	    public void test() {
		 	try {
		 		Assert.assertNotNull(confDb);
				userService.openDB();
				int count = userService.getCountUser();
				Assert.assertNotEquals(0, count);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
			userService.closeDB();
			}
	    }
}
