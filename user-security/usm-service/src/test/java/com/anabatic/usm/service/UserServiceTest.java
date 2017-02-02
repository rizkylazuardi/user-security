package com.anabatic.usm.service;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anabatic.usm.persistence.config.ConfigurationDatabase;
import com.anabatic.usm.persistence.entity.CoreUser;
import com.anabatic.usm.service.api.UserService;
import com.anabatic.usm.service.impl.UserServiceImpl;

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
	 
	 @Test
	    public void test_ml_always_return_true() {
		
	        //assert correct type/impl
		 	userService.openDB();
	        MatcherAssert.assertThat(userService, Matchers.instanceOf(UserServiceImpl.class));
	        //assert true
	        MatcherAssert.assertThat(userService.getCountUser(), Matchers.greaterThanOrEqualTo(0)  );
	        userService.closeDB();System.out.println();
	  }
	 
	 
	 @Test
	 public void getByUsernameTest(){
		 	try {
		 		Assert.assertNotNull(confDb);
				userService.openDB();  
				CoreUser user = new CoreUser();
				user = userService.getByUsername("admin");
				Assert.assertNotNull(user);
				System.out.println(user.toString());
			} catch (Exception e) {
				e.printStackTrace();
				MatcherAssert.assertThat(e, Matchers.equalTo(null));
			}finally{
			userService.closeDB();
			}
	 }
	 
	 @Test
	 public void getByIdTest(){
		 	try {
		 		Assert.assertNotNull(confDb);
				userService.openDB();  
				CoreUser user = new CoreUser();
				user = userService.getById(1L);
				Assert.assertNotNull(user);
				System.out.println(user.toString());
			} catch (Exception e) {
				e.printStackTrace();
				MatcherAssert.assertThat(e, Matchers.equalTo(null));
			}finally{
			userService.closeDB();
			}
	 }
	 
	 @Test
	 public void userSoftDeleteTest(){
		 	try {
		 		Assert.assertNotNull(confDb);
				userService.openDB();  
				userService.userSoftDelete(1L);
			}finally{
			userService.closeDB();
			}
	 }
}

