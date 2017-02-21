package com.anabatic.usm.api;

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
import com.anabatic.usm.service.api.CoreMenuService;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {AppConfig.class})
@ContextConfiguration(locations = {"classpath:applicationContext-service-test.xml",
		"classpath:applicationContext-persistence-test.xml"})
/**
 * Belum ada validator
 *
 */
public class CoreMenuTest {
	

	 @Autowired
	 @Qualifier("coreMenuService")
	 private CoreMenuService menuService;
	 
	 @Autowired
	 ConfigurationDatabase confDb;

	 CoreMenu dataAdd = new CoreMenu();
	 CoreMenu dataUpdate = new CoreMenu();
	 CoreMenu dataDelete = new CoreMenu();
	
	 private Object e;
	 
	 
	 
	 @Test
	   public void testGetMenuById () {
		 	try {
		 		CoreMenu menu = new CoreMenu();
				menu.setId(511L);
				menu = menuService.getMenuById(menu); 
				System.out.println(menu.getId());
				Assert.assertNotNull(menu);
			} catch (Exception e) {
				e.printStackTrace();
				MatcherAssert.assertThat(e, Matchers.equalTo(null));
			}
		 	
	 }
	
	 @Test
	   public void testGetByMenuCode () {
		 	try {
		 		CoreMenu menu = new CoreMenu();
				menu.setMenuCode("Test");
				menu = menuService.getMenuByMenuCode(menu); 
				Assert.assertNotNull(menu);
			} catch (Exception e) {
				e.printStackTrace();
				MatcherAssert.assertThat(e, Matchers.equalTo(null));
			}
	 }		
	
	 @Test
	   public void testGetMenuByParent () {
		 	try {
		 		CoreMenu menu = new CoreMenu();
				menu.setParentMenuCode("menu");
				menu = menuService.getMenuByParent(menu); 
				Assert.assertNotNull(menu);
			} catch (Exception e) {
				e.printStackTrace();
				MatcherAssert.assertThat(e, Matchers.equalTo(null));
			}
	 }
			
	 @Test
	   public void testGetAllMenu () {
		 	try {
		 		Assert.assertNotNull(confDb);
				List<CoreMenu> listMenu = menuService.findAll(new CoreMenu());
				
				Assert.assertNotNull(listMenu);
			} catch (Exception e) {
				e.printStackTrace();
				MatcherAssert.assertThat(e, Matchers.equalTo(null));
			}
	 }
			
	 @Before
	 public void beforeAdd(){
		 //data.setId(151l);
		 //dataAdd.setMenuCode("M-008");
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
		 Exception ex = null;
		 
		 if(dataAdd.getMenuCode() == null || dataAdd.getMenuCode().equalsIgnoreCase("")){
			 	ex = new Exception("MenuCode cannot null");
		 }
		 
		 if(ex != null){
			 	
		 }else{
		 menuService.insert(dataAdd);
		 }
	 
			MatcherAssert.assertThat(e, Matchers.equalTo(null));
		
		 }	

	
	@Test
	 public void test(){
		 try{
			 CoreMenu data = new CoreMenu();
			 //data.setId(151l);
			 data.setId(151L);
			 data.setTitle("abcd");
			 menuService.updateMenu(data);
			 MatcherAssert.assertThat(e, Matchers.equalTo(null));
	 	
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}

	 @Test
	 public void testSoftDelete(){
		 try{
	 CoreMenu data = new CoreMenu();
	 data.setId(151L);
	 data.setStatus("hist");
	 menuService.updateSoftDelete(data);
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	 }

}
