package com.anabatic.usm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anabatic.usm.core.enumeration.SecurityQuestionEnum;
import com.anabatic.usm.persistence.config.ConfigurationDatabase;
import com.anabatic.usm.persistence.entity.CoreRole;
import com.anabatic.usm.persistence.entity.CoreUser;
import com.anabatic.usm.service.api.RoleService;
import com.anabatic.usm.service.api.UserService;
import com.anabatic.usm.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(classes = {AppConfig.class})
@ContextConfiguration(locations = { "classpath:applicationContext-service-test.xml",
		"classpath:applicationContext-persistence-test.xml" })
public class UserServiceTest {
	@Autowired@Qualifier("userService")
	private UserService userService;
	
	@Autowired@Qualifier("RoleService")
	private RoleService roleService;
	
	@Autowired
	ConfigurationDatabase confDb;
	
	CoreUser dataUpdate = new CoreUser();
	CoreUser dataInsert = new CoreUser();

	@Test
	public void test() {
		try {
			Assert.assertNotNull(confDb);
			userService.openDB();

			int count = userService.getCountUser();
			Assert.assertNotEquals(0, count);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			userService.closeDB();

		}
	}

	@Test
	public void test_ml_always_return_true() {

		// assert correct type/impl
		userService.openDB();
		MatcherAssert.assertThat(userService, Matchers.instanceOf(UserServiceImpl.class));
		// assert true
		MatcherAssert.assertThat(userService.getCountUser(), Matchers.greaterThanOrEqualTo(0));
		userService.closeDB();
		System.out.println();
	}

	@Test
	public void getByUsernameTest() {
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
		} finally {
			userService.closeDB();
		}
	}

	@Test
	public void getByIdTest() {
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
		} finally {
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


	@Test
	public void getAllUserTest() {
		try {
			Assert.assertNotNull(confDb);
			userService.openDB();
			List<CoreUser> user = new ArrayList<CoreUser>();
			user = userService.getAllUser();
			Assert.assertNotNull(user);
			System.out.println(user.toString());
		} catch (Exception e) {
			e.printStackTrace();
			MatcherAssert.assertThat(e, Matchers.equalTo(null));
		} finally {
			userService.closeDB();
		}
	}
	
	@Before
	public void beforeUpdate(){
		dataUpdate.setId(146L);
		dataUpdate.setUsername("maman");
		dataUpdate.setSecQuestion(SecurityQuestionEnum.QUESTION_BORN_PLACE);
		dataUpdate.setSecAnswer("apartment");
		dataUpdate.setUpdatedBy(dataUpdate.getUsername());
		dataUpdate.setUpdatedTime(new Date());
		dataUpdate.setActivated(true);
		dataUpdate.setAccountEnabled(true);
		dataUpdate.setMsisdn("08123456789113");
		dataUpdate.setAccountNonLocked(true);
		dataUpdate.setAccountNonExpired(true);

	}
	
	
	@Test
	public void updateUserTest(){
		CoreUser user = new CoreUser();
		user.setId(146L);
		user.setUsername("maman");
		user.setSecQuestion(SecurityQuestionEnum.QUESTION_BORN_PLACE);
		user.setSecAnswer("apartment");
		user.setUpdatedBy(user.getUsername());
		user.setUpdatedTime(new Date());
		user.setActivated(true);
		user.setAccountEnabled(true);
		user.setMsisdn("08123456789113");
		user.setAccountNonLocked(true);
		user.setAccountNonExpired(true);
		
		Long idRole = 74L;
		CoreRole role = roleService.getRoleByID(idRole);
		user.setActiveRole(role);
		
		try {
			Assert.assertNotNull(confDb);
			userService.openDB();
			userService.insert(user);
			Assert.assertNotNull(user.getUsername());
			Assert.assertNotNull(user.getPassword());
			
			CoreUser updatedUser = userService.getByUsername(user.getUsername());
			Assert.assertEquals(user.getUsername(), updatedUser.getUsername());
			System.out.println(updatedUser.toString());
			System.out.println(user.toString());
		} catch (Exception e) {
			e.printStackTrace();
			MatcherAssert.assertThat(e, Matchers.equalTo(null));
		} finally {
			userService.closeDB();
		}
		
	}
	
	
	@Before
	public void beforeInsert(){
			dataInsert.setUsername("mimin");
		dataInsert.setPassword("111111");
		dataInsert.setSecQuestion(SecurityQuestionEnum.QUESTION_BORN_PLACE);
		dataInsert.setSecAnswer("rumah");
		dataInsert.setCreatedBy(dataInsert.getUsername());
		dataInsert.setStatus("LIVE");
		dataInsert.setCreatedTime(new Date());
		dataInsert.setFirstName("Rina");
		dataInsert.setMiddleName("Melati");
		dataInsert.setLastName("Eliserbet");
		dataInsert.setActivated(true);
		dataInsert.setAccountEnabled(true);
		dataInsert.setMsisdn("08123456789112");
		dataInsert.setAccountNonLocked(true);
		dataInsert.setAccountNonExpired(true);
	
	}
	
	@Test
	public void insertUserTest(){
		CoreUser user = new CoreUser();
		user.setUsername("mimin");
		user.setPassword("111111");
		user.setSecQuestion(SecurityQuestionEnum.QUESTION_BORN_PLACE);
		user.setSecAnswer("rumah");
		user.setCreatedBy(user.getUsername());
		user.setStatus("LIVE");
		user.setCreatedTime(new Date());
		user.setFirstName("Rina");
		user.setMiddleName("Melati");
		user.setLastName("Eliserbet");
		user.setActivated(true);
		user.setAccountEnabled(true);
		user.setMsisdn("08123456789112");
		user.setAccountNonLocked(true);
		user.setAccountNonExpired(true);
		
		Long idRole = 74L;
		CoreRole role = roleService.getRoleByID(idRole);
		user.setActiveRole(role);
		
		try {
			Assert.assertNotNull(confDb);
			userService.openDB();
			userService.insert(user);
			Assert.assertNotNull(user.getUsername());
			Assert.assertNotNull(user.getPassword());
			
			CoreUser insertedUser = userService.getByUsername(user.getUsername());
			Assert.assertEquals(user.getUsername(), insertedUser.getUsername());
			System.out.println(insertedUser.toString());
			System.out.println(user.toString());
		} catch (Exception e) {
			e.printStackTrace();
			MatcherAssert.assertThat(e, Matchers.equalTo(null));
		} finally {
			userService.closeDB();
		}
		
	}
}
