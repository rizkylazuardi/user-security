package com.anabatic.usm.service;


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

import com.anabatic.usm.persistence.config.ConfigurationDatabase;
import com.anabatic.usm.persistence.entity.CoreRole;
import com.anabatic.usm.service.api.RoleService;

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

	CoreRole dataAdd = new CoreRole(); 
	CoreRole dataUpdate = new CoreRole();
	 @Test
	   public void testGetRoleById() {
		 	try {
		 		Assert.assertNotNull(confDb);
				roleService.openDB();  
				CoreRole role = new CoreRole();
				role.setId(123L);
				role = roleService.getRoleByID(role);
				Assert.assertNotNull(role);
			} catch (Exception e) {
				e.printStackTrace();
				MatcherAssert.assertThat(e, Matchers.equalTo(null));
			}finally{
			roleService.closeDB();
			
			}
	    }
	 
	 @Test
	 public void testGetAllRole(){
		 try {
		 		Assert.assertNotNull(confDb);
				roleService.openDB();
				List<CoreRole> listRole = roleService.findAll(new CoreRole());
				Assert.assertNotNull(listRole);
			} catch (Exception e) {
				e.printStackTrace();
				MatcherAssert.assertThat(e, Matchers.equalTo(null));
			}finally{
			roleService.closeDB();
			
			}
	 }
	 
	 
	 
	 @Test
	   public void testGetRoleByName() {
		 	try {
		 		Assert.assertNotNull(confDb);
				roleService.openDB();  
				CoreRole role = new CoreRole();
				role.setName("integer");
				role = roleService.getRoleByName(role);
			} catch (Exception e) {
				e.printStackTrace();
				MatcherAssert.assertThat(e, Matchers.equalTo(null));
				
		 	}finally{
					
			roleService.closeDB();
			
			}
	    }
	 
	 	@Before
	 	public void	beforeAdd(){
	 	 
		//data.setId(92L);
		 dataAdd.setName("name1");
		 dataAdd.setDescription("description1");
		 dataAdd.setDescription_en("description_en_1");
	 	}
	 
	 
	 
	 @Test
	 public void testAdd(){
		 try{
		 CoreRole data = new CoreRole();
		 //data.setId(92L);
		 data.setName("diyaz");
		 data.setDescription("adas");
		 data.setDescription_en("adjasd");
		 roleService.openDB();
		 roleService.insert(data);
			} catch (Exception e) {
				e.printStackTrace();
				MatcherAssert.assertThat(e, Matchers.equalTo(null));
	
		 }finally{	
		 roleService.closeDB();
	 	 }
	 }

	 @Before
	 public void beforeUpdate(){
		 dataUpdate.setId(123L);
		 dataUpdate.setDescription("bangjonathan");
		 dataUpdate.setDescription_en("bangjonathan");
 
	 
	 
	 
	 }
	 @Test
		 public void testupdateRoleById(){
			 try{
			roleService.openDB();
			CoreRole data = new CoreRole();
			 data.setId(123L);
			 data.setDescription("bangjonathan");
			 data.setDescription_en("bangjonathan");
			roleService.updateRoleById(data);
			
				} catch (Exception e) {
					e.printStackTrace();
					MatcherAssert.assertThat(e, Matchers.equalTo(null));
				
			 }finally{	
				 roleService.closeDB();
			 }
	} 
		@Test
		public void testSoftDelete(){
			try{

			roleService.openDB();
			CoreRole data= new CoreRole();
			data.setId(123L);
			data.setStatus("hist");
			
			
			roleService.updateSoftDelete(data);;
		
			} catch (Exception e) {
				e.printStackTrace();
				MatcherAssert.assertThat(e, Matchers.equalTo(null));
	
			}finally{
				roleService.closeDB();
			
							}
			}
}