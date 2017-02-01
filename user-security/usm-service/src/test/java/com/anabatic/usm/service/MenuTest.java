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
import com.anabatic.usm.persistence.entity.CoreMenu;
import com.anabatic.usm.service.api.MenuService;
import com.anabatic.usm.service.api.UserService;
import com.anabatic.usm.service.impl.MenuServiceImpl;
import com.anabatic.usm.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {AppConfig.class})
@ContextConfiguration(locations = {"classpath:applicationContext-service-test.xml",
		"classpath:applicationContext-persistence-test.xml"})
public class MenuTest {
	

	 @Autowired
	 @Qualifier("menuService")
	 MenuService menuService;
	 
	 @Autowired
	 ConfigurationDatabase confDb;

	 CoreMenu dataAdd = new CoreMenu();
	
	 private Object e;
	 
	 
	 
	 @Test
	   public void testGetMenuById () {
		 	try {
		 		Assert.assertNotNull(confDb);
				menuService.openDB();    
				CoreMenu menu = new CoreMenu();
				menu.setId(151L);
				menu = menuService.getMenuById(menu); 
				Assert.assertNotNull(menu);
			} catch (Exception e) {
				e.printStackTrace();
				MatcherAssert.assertThat(e, Matchers.equalTo(null));
			}finally{
			menuService.closeDB();
			
			
						}
	    	}
	
	 @Test
	   public void testGetByParent () {
		 	try {
		 		Assert.assertNotNull(confDb);
				menuService.openDB(); 
				
				CoreMenu menu = new CoreMenu();
				menu.setMenuCode("Test");
				menu = menuService.getMenuByMenuCode(menu); 
				Assert.assertNotNull(menu);
			} catch (Exception e) {
				e.printStackTrace();
				MatcherAssert.assertThat(e, Matchers.equalTo(null));
			}finally{
			menuService.closeDB();
	
			}
	 }		
	
	 @Test
	   public void testGetMenuByCode () {
		 	try {
		 		Assert.assertNotNull(confDb);
				menuService.openDB();    
				CoreMenu menu = new CoreMenu();
				menu.setParentMenuCode("menu");
				menu = menuService.getMenuByParent(menu); 
				Assert.assertNotNull(menu);
			} catch (Exception e) {
				e.printStackTrace();
				MatcherAssert.assertThat(e, Matchers.equalTo(null));
			}finally{
			menuService.closeDB();
			
			
			}
	 }
			
	 @Test
	   public void testGetAllMenu () {
		 	try {
		 		Assert.assertNotNull(confDb);
				menuService.openDB();    
				List<CoreMenu> listMenu = menuService.findAll(new CoreMenu());
			 
				Assert.assertNotNull(listMenu);
			} catch (Exception e) {
				e.printStackTrace();
				MatcherAssert.assertThat(e, Matchers.equalTo(null));
			}finally{
			menuService.closeDB();
			
			
			}
	 }
			
	 @Before
	 public void beforeAdd(){
		 //data.setId(151l);
		 dataAdd.setMenuCode("M-008");
		 dataAdd.setParentMenuCode("M-002");
		 dataAdd.setDescription("Menu 008");
		 dataAdd.setTitle("title tes");
		 dataAdd.setTitleEn("Core 1");
		 dataAdd.setMenuLevel(1);
		 dataAdd.setMenuOrder(1);
		 dataAdd.setAction("add");
		 dataAdd.setAppid(1L);
		 
	 }
	 
	 @Test
	 public void testAdd(){
		 menuService.openDB();
		 menuService.insert(dataAdd);
		 MatcherAssert.assertThat(e, Matchers.equalTo(null));
		 	
		 	menuService.closeDB();
		 	
	 }

	 @Test
	 public void test(){
		 try{
	 CoreMenu data = new CoreMenu();
	 //data.setId(151l);
	 data.setId(151L);
	 data.setTitle("abcd");
	 menuService.openDB();
	 menuService.updateMenuByDimas(data);
	 MatcherAssert.assertThat(e, Matchers.equalTo(null));
	 	
	 	}finally{
	 		menuService.closeDB();
	 	}
			}

	 @Test
	 public void testSoftDelete(){
		 try{
	 	menuService.openDB();
	 CoreMenu data = new CoreMenu();
	 data.setId(151L);
	 data.setStatus("hist");
	 menuService.updateSoftDelete(data);
		 }finally{
	  
	 	menuService.closeDB();
	 	

		 }
	 }

}
