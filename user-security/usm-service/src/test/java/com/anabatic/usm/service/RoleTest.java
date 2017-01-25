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
import com.anabatic.usm.persistence.entity.CoreRole;
import com.anabatic.usm.service.api.RoleService;
import com.anabatic.usm.service.api.UserService;
import com.anabatic.usm.service.impl.RoleServiceImpl;
import com.anabatic.usm.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {AppConfig.class})
@ContextConfiguration(locations = {"classpath:applicationContext-service-test.xml",
		"classpath:applicationContext-persistence-test.xml"})
public class RoleTest {
	@Autowired
	 @Qualifier("RoleService")
	 RoleService roleService;

	 @Autowired
	 ConfigurationDatabase confDb;
	 @Test
	   public void test() {
		 	try {
		 		Assert.assertNotNull(confDb);
				roleService.openDB();     		
			CoreRole id = roleService.getRoleByID("12");
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
			roleService.closeDB();
			
			}
	    }
	
	 @Test
	 public void test_pertama() {

	roleService.openDB();
	CoreRole Role= roleService.getRoleByID("2");
	System.out.println(Role.toString());
    roleService.closeDB();System.out.println();

    
}
}
	