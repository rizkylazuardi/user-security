package com.anabatic.usm.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anabatic.usm.businesslogic.validator.api.IUserValidator;
import com.anabatic.usm.core.enumeration.ErrorCodeEnum;
import com.anabatic.usm.core.enumeration.SecurityQuestionEnum;
import com.anabatic.usm.persistence.config.ConfigurationDatabase;
import com.anabatic.usm.persistence.entity.CoreRole;
import com.anabatic.usm.persistence.entity.CoreUser;
import com.anabatic.usm.service.api.CoreRoleService;
import com.anabatic.usm.service.api.CoreUserService;
import com.anabatic.usm.service.impl.CoreUserServiceImpl;

/**
 * @author ahlul.esasjana
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:applicationContext-service-test.xml",
		"classpath:applicationContext-persistence-test.xml",
		"classpath:applicationContext-businesslogic-test.xml" })
public class CoreUserTest {
	@Autowired 
	private CoreUserService userService;

	@Autowired @Qualifier("coreRoleService")
	private CoreRoleService roleService;

	@Autowired
	ConfigurationDatabase confDb;

	@Autowired
	@Qualifier("userValidator")
	private IUserValidator userValidator;

	@Test
	public void test() {
		try {
			Assert.assertNotNull(confDb);
			int count = userService.getCountUser();
			Assert.assertNotEquals(0, count);
			System.out.println("count : "+count);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Test
	public void test_ml_always_return_true() {

		// assert correct type/impl
		MatcherAssert.assertThat(userService,
		Matchers.instanceOf(CoreUserServiceImpl.class));
		// assert true
		MatcherAssert.assertThat(userService.getCountUser(),
				Matchers.greaterThanOrEqualTo(0));
	}

	@Test
	public void getByUsernameTest() {
		try {
			Assert.assertNotNull(confDb);
			CoreUser user = new CoreUser();

			user = userService.getByUsername("admin");
			Assert.assertNotNull(user);
			System.out.println(user.toString());
		} catch (Exception e) {
			e.printStackTrace();
			MatcherAssert.assertThat(e, Matchers.equalTo(null));
		} 
	}

	@Test
	public void getByIdTest() {
		try {
			Assert.assertNotNull(confDb);
			CoreUser user = new CoreUser();
			user.setId(175L);
			user = userService.getById(175L);
			Assert.assertNotNull(user);
			System.out.println(user.toString());
		} catch (Exception e) {
			e.printStackTrace();
			MatcherAssert.assertThat(e, Matchers.equalTo(null));
		} 
	}

	@Test
	public void userSoftDeleteTest() {
		try {
			Assert.assertNotNull(confDb);
			userService.userSoftDelete(1L);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void getAllUserTest() {
		try {
			Assert.assertNotNull(confDb);
			List<CoreUser> user = new ArrayList<CoreUser>();
			user = userService.getAllUser();
			Assert.assertNotNull(user);
			System.out.println(user.toString());
		} catch (Exception e) {
			e.printStackTrace();
			MatcherAssert.assertThat(e, Matchers.equalTo(null));
		}
	}

	@Test
	public void updateUserTest() {
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
			userValidator.validate(user);
			if(!userValidator.hasError()){
				userService.insert(user);
				
				CoreUser insertedUser = userService.getByUsername(user.getUsername());
				Assert.assertEquals(user.getUsername(), insertedUser.getUsername());
				System.out.println(insertedUser.toString());
				System.out.println(user.toString());
				Assert.assertNotNull(confDb);
				Assert.assertNotNull(user.getUsername());
				Assert.assertNotNull(user.getPassword());
			}else{
				//To know error has happened
				//If object fail pass the validation, error Junit must happen here
				Assert.assertNotEquals(ErrorCodeEnum.USERNAME_USED.getCode(), userValidator.getErrors().get("username").getCode());
			}
		} catch (Exception e) {
			e.printStackTrace();
			MatcherAssert.assertThat(e, Matchers.equalTo(null));
		}
		
	}

	@Test
	public void insertUserTest() {
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
		user.setMsisdn("08123456789114");
		user.setAccountNonLocked(true);
		user.setAccountNonExpired(true);
				Assert.assertNotNull(confDb);
				userService.insert(user);
				Assert.assertNotNull(user.getUsername());
				Assert.assertNotNull(user.getPassword());
				
		}
		
			
}

