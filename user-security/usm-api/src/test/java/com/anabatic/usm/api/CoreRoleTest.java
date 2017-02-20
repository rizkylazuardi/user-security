//package com.anabatic.usm.api;
//
//import java.util.List;
//
//import org.hamcrest.MatcherAssert;
//import org.hamcrest.Matchers;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.anabatic.usm.persistence.config.ConfigurationDatabase;
//import com.anabatic.usm.persistence.entity.CoreRole;
//import com.anabatic.usm.service.api.CoreRoleService;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//// @ContextConfiguration(classes = {AppConfig.class})
//@ContextConfiguration(locations = {"classpath:applicationContext-service-test.xml",
//"classpath:applicationContext-persistence-test.xml"})
//public class CoreRoleTest {
//	@Autowired
//	@Qualifier("coreRoleService")
//	private CoreRoleService roleService;
//
//	@Autowired
//	ConfigurationDatabase confDb;
//
//	CoreRole dataAdd = new CoreRole();
//	CoreRole dataUpdate = new CoreRole();
//	CoreRole dataDelete = new CoreRole();
//
//	@Test
//	public void testGetRoleById() {
//		try {
//			Assert.assertNotNull(confDb);
//			roleService.openDB();
//			CoreRole role = new CoreRole();
//			role.setId(153L);
//			role = roleService.getRoleByID(role);
//			Assert.assertNotNull(role);
//			System.out.println(role.getName());
//		} catch (Exception e) {
//			e.printStackTrace();
//			MatcherAssert.assertThat(e, Matchers.equalTo(null));
//		} finally {
//			roleService.closeDB();
//
//		}
//	}
//
//	@Test
//	public void testGetAllRole() {
//		try {
//			Assert.assertNotNull(confDb);
//			roleService.openDB();
//			List<CoreRole> listRole = roleService.findAll(new CoreRole());
//			Assert.assertNotNull(listRole);
//		} catch (Exception e) {
//			e.printStackTrace();
//			MatcherAssert.assertThat(e, Matchers.equalTo(null));
//		} finally {
//			roleService.closeDB();
//
//		}
//	}
//
//	@Test
//	public void testGetRoleByName() {
//		try {
//			Assert.assertNotNull(confDb);
//			roleService.openDB();
//			CoreRole role = new CoreRole();
//			role.setName("integer");
//			role = roleService.getRoleByName(role);
//		} catch (Exception e) {
//			e.printStackTrace();
//			MatcherAssert.assertThat(e, Matchers.equalTo(null));
//
//		} finally {
//
//			roleService.closeDB();
//
//		}
//	}
//
//	@Before
//	public void beforeAdd() {
//
//		dataAdd.setId(92L);
//		dataAdd.setName("name1");
//		dataAdd.setDescription("description1");
//		dataAdd.setDescription_en("description_en_1");
//	}
//
//	@Test
//	public void testAdd() {
//		try {
//			roleService.openDB();
//
//			Exception ex = null;
//
//			if (dataAdd.getName() == null
//					|| dataAdd.getName().equalsIgnoreCase("")) {
//
//				ex = new Exception("Name cannot null");
//			}
//
//			if (dataAdd.getDescription() == null
//					|| dataAdd.getDescription().equalsIgnoreCase("")) {
//				ex = new Exception("Description cannot null");
//			}
//
//			if (ex != null) {
//				Assert.fail(ex.getMessage());
//				throw ex;
//			} else {
//				roleService.insert(dataAdd);
//			}
//
//			if (dataAdd.getDescription() == null
//					|| dataAdd.getDescription().equalsIgnoreCase("")) {
//				ex = new Exception("Description cannot null");
//			}
//
//			if (ex != null) {
//				throw ex;
//			} else {
//				roleService.insert(dataAdd);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			MatcherAssert.assertThat(e, Matchers.equalTo(null));
//
//		} finally {
//			roleService.closeDB();
//		}
//	}
//
//	@Before
//	public void beforeUpdate() {
//		dataUpdate.setId(123L);
//		dataUpdate.setDescription("bangjonathan");
//		dataUpdate.setDescription_en("bangjonathan");
//
//	}
//
//	@Test
//	public void testupdateRoleById() {
//		try {
//			roleService.openDB();
//			Exception ex = null;
//
//			if (dataAdd.getDescription() == null
//					|| dataAdd.getDescription().equalsIgnoreCase("")) {
//				ex = new Exception("Description cannot null");
//			}
//
//			if (dataAdd.getDescription_en() == null
//					|| dataAdd.getDescription_en().equalsIgnoreCase("")) {
//				ex = new Exception("Description_en cannot null");
//			}
//
//			if (ex != null) {
//				throw ex;
//			} else {
//
//			}
//
//			if (dataAdd.getName() == null
//					|| dataAdd.getName().equalsIgnoreCase("")) {
//				ex = new Exception("Name cannot null");
//			}
//
//			if (ex != null) {
//				throw ex;
//			} else {
//				roleService.insert(dataUpdate);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			MatcherAssert.assertThat(e, Matchers.equalTo(null));
//
//		} finally {
//			roleService.closeDB();
//		}
//	}
//
//	@Before
//	public void dataDelete() {
//		dataDelete.setId(123L);
//		dataDelete.setStatus("hist");
//	}
//
//	@Test
//	public void testSoftDelete() {
//		try {
//
//			roleService.openDB();
//			Exception ex = null;
//
//			if (dataAdd.getStatus() == null
//					|| dataAdd.getStatus().equalsIgnoreCase("")) {
//				ex = new Exception("Status cannot null");
//			}
//
//			if (ex != null) {
//				throw ex;
//			} else {
//
//				roleService.insert(dataDelete);
//				;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			MatcherAssert.assertThat(e, Matchers.equalTo(null));
//
//		} finally {
//			roleService.closeDB();
//
//		}
//	}
//}