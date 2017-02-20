//package com.anabatic.usm.api;
//
//import java.util.List;
//
//import org.hamcrest.MatcherAssert;
//import org.hamcrest.Matchers;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//
//import com.anabatic.usm.businesslogic.validator.api.IMenuValidator;
//import com.anabatic.usm.core.enumeration.ErrorCodeEnum;
//import com.anabatic.usm.persistence.config.ConfigurationDatabase;
//import com.anabatic.usm.persistence.entity.CoreMenu;
//import com.anabatic.usm.service.api.CoreMenuService;
//
//public class MenuValidatorTest {
//
//	@Autowired
//	@Qualifier("menuService")
//	CoreMenuService menuService;
//
//	@Autowired
//	ConfigurationDatabase confDb;
//
//	CoreMenu dataAdd = new CoreMenu();
//	CoreMenu dataUpdate = new CoreMenu();
//	CoreMenu dataDelete = new CoreMenu();
//
//	@Autowired
//	@Qualifier("menuValidator")
//	private IMenuValidator menuValidator;
//
//	private Object e;
//
//	@Before
//	public void beforeUpdateMenu() {
//		dataUpdate.setId(151L);
//		dataUpdate.setDescription("Validator");
//
//	}
//
//	@Test
//	public void testGetMenuById() {
//		try {
//			Assert.assertNotNull(confDb);
//			menuService.openDB();
//			CoreMenu menu = new CoreMenu();
//			menu.setId(151L);
//			menu = menuService.getMenuById(menu);
//			Assert.assertNotNull(menu);
//		} catch (Exception e) {
//			e.printStackTrace();
//			MatcherAssert.assertThat(e, Matchers.equalTo(null));
//		} finally {
//			menuService.closeDB();
//
//		}
//	}
//
//	@Test
//	public void testGetByParent() {
//		try {
//			Assert.assertNotNull(confDb);
//			menuService.openDB();
//
//			CoreMenu menu = new CoreMenu();
//			menu.setMenuCode("Test");
//			menu = menuService.getMenuByMenuCode(menu);
//			Assert.assertNotNull(menu);
//		} catch (Exception e) {
//			e.printStackTrace();
//			MatcherAssert.assertThat(e, Matchers.equalTo(null));
//		} finally {
//			menuService.closeDB();
//
//		}
//	}
//
//	@Test
//	public void testGetMenuByCode() {
//		try {
//			Assert.assertNotNull(confDb);
//			menuService.openDB();
//			CoreMenu menu = new CoreMenu();
//			menu.setParentMenuCode("menu");
//			menu = menuService.getMenuByParent(menu);
//			Assert.assertNotNull(menu);
//		} catch (Exception e) {
//			e.printStackTrace();
//			MatcherAssert.assertThat(e, Matchers.equalTo(null));
//		} finally {
//			menuService.closeDB();
//
//		}
//	}
//
//	@Test
//	public void menuSoftDeleteTest() {
//		CoreMenu menu = new CoreMenu();
//		dataDelete.setId(151L);
//		dataDelete.setStatus("hist");
//
//		try {
//			menuValidator.validate(menu);
//			if (!menuValidator.hasError()) {
//				CoreMenu deletedMenu = menuService.getMenuById(menu.getId());
//				Assert.assertEquals(menu.getId(), deletedMenu.getId());
//				System.out.println(deletedMenu.toString());
//				System.out.println(menu.toString());
//				Assert.assertNotNull(confDb);
//				Assert.assertNotNull(confDb);
//				menuService.openDB();
//				menuService.updateSoftDelete(1L);
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			MatcherAssert.assertThat(e, Matchers.equalTo(null));
//
//		} finally {
//			menuService.closeDB();
//		}
//	}
//	
//	@Test
//	public void testGetAllMenu() {
//		try {
//			Assert.assertNotNull(confDb);
//			menuService.openDB();
//			List<CoreMenu> listMenu = menuService.findAll(new CoreMenu());
//
//			Assert.assertNotNull(listMenu);
//		} catch (Exception e) {
//			e.printStackTrace();
//			MatcherAssert.assertThat(e, Matchers.equalTo(null));
//		} finally {
//			menuService.closeDB();
//
//		}
//	}
//
//	@Before
//	public void beforeUpdate() {
//		dataUpdate.setId(151L);
//		dataUpdate.setDescription("Validator");
//
//	}
//
//	@Test
//	public void updateMenuTest() {
//		CoreMenu menu = new CoreMenu();
//		
//		// Long idMenu = 74L;
//		// CoreMenu menu = menuService.getMenuById(idMenu);
//		// user.setActiveMenu(menu);
//		
//		try {
//			menuValidator.validate(menu);
//			if (!menuValidator.hasError()) {
//				CoreMenu updatedMenu = menuService.getMenuById(menu.getId());
//				Assert.assertEquals(menu.getId(), updatedMenu.getId());
//				System.out.println(updatedMenu.toString());
//				System.out.println(menu.toString());
//				Assert.assertNotNull(confDb);
//				menuService.openDB();
//
//			} else {
//				// To know error has happened
//				// If object fail pass the validation, error Junit must happen
//				// here
//				Assert.assertNotEquals(ErrorCodeEnum.USERNAME_USED.getCode(),
//						menuValidator.getErrors().get("username").getCode());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			MatcherAssert.assertThat(e, Matchers.equalTo(null));
//		} finally {
//			menuService.closeDB();
//		}
//
//	}
//
//	@Before
//	public void beforeAdd() {
//		// data.setId(151l);
//		// dataAdd.setMenuCode("M-008");
//		dataAdd.setParentMenuCode("M-002");
//		dataAdd.setDescription("Menu 008");
//		dataAdd.setTitle("title tes");
//		dataAdd.setTitleEn("Core 1");
//		dataAdd.setMenuLevel(1);
//		dataAdd.setMenuOrder(1);
//		dataAdd.setAction("add");
//		dataAdd.setAppid(1L);
//
//	}
//	
//	@Test
//	public void testAdd() {
//		CoreMenu menu = new CoreMenu();
//		dataAdd.setId(151L);
//		dataAdd.setDescription("Hist");
//		
//		try {
//			menuValidator.validate(menu);
//			if (!menuValidator.hasError()) {
//				CoreMenu addedMenu = menuService.getMenuById(menu.getId());
//				Assert.assertEquals(menu.getId(), addedMenu.getId());
//				System.out.println(addedMenu.toString());
//				System.out.println(menu.toString());
//				Assert.assertNotNull(confDb);
//				menuService.openDB();
//				
//			} else {
//				// To know error has happened
//				// If object fail pass the validation, error Junit must happen
//				// here
//				Assert.assertNotEquals(ErrorCodeEnum.USERNAME_USED.getCode(),
//						menuValidator.getErrors().get("username").getCode());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			MatcherAssert.assertThat(e, Matchers.equalTo(null));
//		} finally {
//			menuService.closeDB();
//		}
//		
//	}
//	
//	@Test
//	public void test() {
//		try {
//			CoreMenu data = new CoreMenu();
//			// data.setId(151l);
//			data.setId(151L);
//			data.setTitle("abcd");
//			menuService.openDB();
//			menuService.updateMenu(data);
//			MatcherAssert.assertThat(e, Matchers.equalTo(null));
//
//		} finally {
//			menuService.closeDB();
//		}
//	}
//
//	@Test
//	public void testSoftDelete() {
//		try {
//			menuService.openDB();
//			CoreMenu data = new CoreMenu();
//			data.setId(151L);
//			data.setStatus("hist");
//			menuService.updateSoftDelete(data);
//		} finally {
//
//			menuService.closeDB();
//
//		}
//
//	}
//}
