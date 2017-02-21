//package com.anabatic.usm.api;
//
//
//import java.util.Date;
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
//import com.anabatic.usm.businesslogic.validator.api.IRoleValidator;
//import com.anabatic.usm.core.enumeration.DataStatusEnum;
//import com.anabatic.usm.core.enumeration.ErrorCodeEnum;
//import com.anabatic.usm.persistence.config.ConfigurationDatabase;
//import com.anabatic.usm.persistence.entity.CoreRole;
//import com.anabatic.usm.service.api.CoreRoleService;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {
//		"classpath*:applicationContext-service-test.xml",
//		"classpath*:applicationContext-persistence-test.xml",
//		"classpath*:applicationContext-businesslogic-test.xml" })
//public class RoleValidatorTest {
//	@Autowired
//	CoreRoleService roleService;
//
//	@Autowired
//	ConfigurationDatabase confDb;
//	
//	@Autowired
//	@Qualifier("roleValidator")
//	
//	private IRoleValidator roleValidator;
//	private CoreRole dataAdd = new CoreRole();
//	private CoreRole dataUpdate = new CoreRole();
//	private CoreRole dataDelete = new CoreRole();
//
//	 @Test
//	 public void testGetRoleById() {
//		 try {
//			 Assert.assertNotNull(confDb);
//			 roleService.openDB();
//			 CoreRole role = new CoreRole();
//			 role.setId(123L);
//			 role = roleService.getRoleByID(role);
//			 Assert.assertNotNull(role);
//		 } catch (Exception e) {
//			 e.printStackTrace();
//			 MatcherAssert.assertThat(e, Matchers.equalTo(null));
//		 } finally {
//			 roleService.closeDB();
//		 }
//	 }
//	
//	 @Test
//	 public void testGetAllRole() {
//		 try {
//			 Assert.assertNotNull(confDb);
//			 roleService.openDB();
//			 List<CoreRole> listRole = roleService.findAll(new CoreRole());
//			 Assert.assertNotNull(listRole);
//		 } catch (Exception e) {
//			 e.printStackTrace();
//			 MatcherAssert.assertThat(e, Matchers.equalTo(null));
//		 } finally {
//			 roleService.closeDB();
//		 }
//	 }
//	
//	 @Test
//	 public void testGetRoleByName() {
//		 try {
//			 Assert.assertNotNull(confDb);
//			 roleService.openDB();
//			 CoreRole role = new CoreRole();
//			 role.setName("integer");
//			 role = roleService.getRoleByName(role);
//		 } catch (Exception e) {
//			 e.printStackTrace();
//			 MatcherAssert.assertThat(e, Matchers.equalTo(null));
//		 } finally {
//			 roleService.closeDB();
//		 }
//	 }
//
//	@Before
//	public void beforeAdd() {
//
//		dataAdd.setId(92L);
//		dataAdd.setName("name1");
//		dataAdd.setDescription("description1");
//		dataAdd.setDescription_en("description_en_1");
//		
//		dataAdd.setCreatedTime(new Date());
//		dataAdd.setCreatedBy("admin");
//		dataAdd.setStatus(DataStatusEnum.LIVE.name());
//	}
//
//	@Test
//	public void testAdd() {
//		
//		CoreRole role = new CoreRole();// ini buat apa?
//		dataAdd.setName("pretet");// ini kenapa di set lagi?? ,, kan udah di beforeAdd
//		dataAdd.setDescription("desc");//ini juga
//		dataAdd.setDescription_en("desc_en");//ini juga
//		try {
//			roleService.openDB();
//			roleValidator.validate(role);//yang di set objectnnya= dataAdd, kenapa yang di validate = role ?? 
//			if (!roleValidator.hasError()) {
//				roleService.insert(dataAdd);
//				//kalo ga butuh di hapus aja commentnya
//				/*
//				 * CoreRole addedRole = roleService.getRoleByName(role
//				 * .getName()); Assert.assertEquals(role.getName(),
//				 * addedRole.getName());
//				 * System.out.println(addedRole.toString());
//				 * System.out.println(role.toString());
//				 */
//			} else {
//				// To know error has happened
//				// If object fail pass the validation, error Junit must
//				// happen here
//				Assert.assertNotEquals(ErrorCodeEnum.USERNAME_USED.getCode(),
//						roleValidator.getErrors().get("username").getCode());
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
//	public void updateRoleById() {
//		CoreRole role = new CoreRole();//object ini buat apa?? kan udah ada object dataUpdate
//		dataUpdate.setId(123L);
//		dataUpdate.setDescription("bangjhonathan");
//		dataUpdate.setDescription_en("bangjhonathan");
//		
//		// Long IdRole = 123L;
//		// CoreRole role = roleService.updateRoleById (idRole);
//		// Role.setActiveRole(role);
//
//		try {
//			roleValidator.validate(role);//kenapa yang di validate = object role
//			if (!roleValidator.hasError()) {
//				//fungsi updatenya mana??
//				
//				
//				
//				// CoreRole updatedRole = roleService
//				// .getRoleByID(role.getId());
//				// Assert.assertEquals(role.getId(), updatedRole.getId());
//				// System.out.println(updatedRole.toString());
//				// System.out.println(role.toString());
//				// roleService.openDB();
//				// roleService.updateRoleById(role);
//				// Assert.assertNotNull(role.getId());
//			} else {
//				// To know error has happened
//				// If object fail pass the validation, error Junit must
//				// happen here
//				Assert.assertNotEquals(ErrorCodeEnum.USERNAME_USED.getCode(),
//						roleValidator.getErrors().get("username").getCode());
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
//		CoreRole role = new CoreRole();// kalo ga butuh diapus aja
//		dataDelete.setId(123L);
//		dataDelete.setStatus("hist");
//		//commentnya apus apusin aja kalo ga diperluin
//		// Long IdRole = 123L;
//		// CoreRole role = roleService.getRoleByID (idRole);
//		// Role.setActiveRole(role);
//
//		try {
//			roleService.openDB();
//			roleService.delete(dataDelete);
//			//roleValidator.validate(role);
//			//if (!roleValidator.hasError()) {
//				
//				// CoreRole deletedRole = roleService
//				// .getRoleByID(role.getId());
//				// Assert.assertEquals(role.getId(), deletedRole.getId());
//				// System.out.println(deletedRole.toString());
//				// System.out.println(role.toString());
//				// roleService.openDB();
//				// roleService.getRoleByID(role);
//				// Assert.assertNotNull(role.getId());
//				
//			//	} else {
//					// To know error has happened
//					// If object fail pass the validation, error Junit must
//					// happen here
//				//	Assert.assertNotEquals(
//					//		ErrorCodeEnum.USERNAME_USED.getCode(),
//						//	roleValidator.getErrors().get("username").getCode());
//				//}
//
//			
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