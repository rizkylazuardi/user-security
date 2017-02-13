package com.anabatic.usm.api;

import java.util.Date;

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

import com.anabatic.usm.businesslogic.validator.api.IRoleValidator;
import com.anabatic.usm.core.enumeration.DataStatusEnum;
import com.anabatic.usm.core.enumeration.ErrorCodeEnum;
import com.anabatic.usm.persistence.config.ConfigurationDatabase;
import com.anabatic.usm.persistence.entity.CoreRole;
import com.anabatic.usm.service.api.RoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:applicationContext-service-test.xml",
		"classpath*:applicationContext-persistence-test.xml",
		"classpath*:applicationContext-businesslogic-test.xml" })
public class CoreRoleTest {
	@Autowired
	RoleService roleService;

	@Autowired
	ConfigurationDatabase confDb;
	
	@Autowired
	@Qualifier("roleValidator")
	
	private IRoleValidator roleValidator;
	private CoreRole dataAdd = new CoreRole();
	private CoreRole dataUpdate = new CoreRole();
	private CoreRole dataDelete = new CoreRole();

//	@Test
//	public void testGetRoleById() {
//		try {
//			Assert.assertNotNull(confDb);
//			roleService.openDB();
//			CoreRole role = new CoreRole();
//			role.setId(123L);
//			role = roleService.getRoleByID(role);
//			Assert.assertNotNull(role);
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

	@Before
	public void beforeAdd() {

		dataAdd.setId(92L);
		dataAdd.setName("name1");
		dataAdd.setDescription("description1");
		dataAdd.setDescription_en("description_en_1");
		
		dataAdd.setCreatedTime(new Date());
		dataAdd.setCreatedBy("admin");
		dataAdd.setStatus(DataStatusEnum.LIVE.name());
	}

	@Test
	public void testAdd() {
		CoreRole role = new CoreRole();
		dataAdd.setId(92L);
		dataAdd.setName("name1");
		dataAdd.setDescription("description1");
		dataAdd.setDescription_en("description_en_1");
		// Long idRole(92L);
		// CoreRole role =roleService.getByName(name);
		// role.setActiveRole(role);
		try {
			roleService.openDB();
			roleValidator.validate(role);
			if (!roleValidator.hasError()) {
				roleService.insert(dataAdd);
				/*CoreRole addedRole = roleService.getRoleByName(role
						.getName());
				Assert.assertEquals(role.getName(), addedRole.getName());
				System.out.println(addedRole.toString());
				System.out.println(role.toString());*/
			} else {
				// To know error has happened
				// If object fail pass the validation, error Junit must
				// happen here
				Assert.assertNotEquals(
						ErrorCodeEnum.USERNAME_USED.getCode(),
						roleValidator.getErrors().get("username").getCode());
			}

			

		} catch (Exception e) {
			e.printStackTrace();
			MatcherAssert.assertThat(e, Matchers.equalTo(null));

		} finally {
			roleService.closeDB();
		}
	}

	@Before
	public void beforeUpdate() {
		dataUpdate.setId(123L);
		dataUpdate.setDescription("bangjonathan");
		dataUpdate.setDescription_en("bangjonathan");

	}

	@Test
	public void updateRoleById() {
		CoreRole role = new CoreRole();
		dataUpdate.setId(123L);
		dataUpdate.setDescription("bangjhonathan");
		dataUpdate.setDescription_en("bangjhonathan");

		// Long IdRole = 123L;
		// CoreRole role = roleService.updateRoleById (idRole);
		// Role.setActiveRole(role);

		try {
			roleValidator.validate(role);
			if (!roleValidator.hasError()) {
//				CoreRole updatedRole = roleService
//						.getRoleByID(role.getId());
//				Assert.assertEquals(role.getId(), updatedRole.getId());
//				System.out.println(updatedRole.toString());
//				System.out.println(role.toString());
//				roleService.openDB();
//				roleService.updateRoleById(role);
//				Assert.assertNotNull(role.getId());
			} else {
				// To know error has happened
				// If object fail pass the validation, error Junit must
				// happen here
				Assert.assertNotEquals(
						ErrorCodeEnum.USERNAME_USED.getCode(),
						roleValidator.getErrors().get("username").getCode());
			}

		} catch (Exception e) {
			e.printStackTrace();
			MatcherAssert.assertThat(e, Matchers.equalTo(null));

		} finally {
			roleService.closeDB();
		}
	}

	@Before
	public void dataDelete() {
		dataDelete.setId(123L);
		dataDelete.setStatus("hist");
	}

	@Test
	public void testSoftDelete() {
		CoreRole role = new CoreRole();
		dataDelete.setId(123L);
		dataDelete.setStatus("hist");

		// Long IdRole = 123L;
		// CoreRole role = roleService.getRoleByID (idRole);
		// Role.setActiveRole(role);

		try {
			roleValidator.validate(role);
			if (!roleValidator.hasError()) {
//				CoreRole deletedRole = roleService
//						.getRoleByID(role.getId());
//				Assert.assertEquals(role.getId(), deletedRole.getId());
//				System.out.println(deletedRole.toString());
//				System.out.println(role.toString());
//				roleService.openDB();
//				roleService.getRoleByID(role);
//				Assert.assertNotNull(role.getId());
				roleService.openDB();
				Exception ex = null;
				if (dataAdd.getStatus() == null
						|| dataAdd.getStatus().equalsIgnoreCase("")) {
					ex = new Exception("Status cannot null");
				}

				if (ex != null) {
					throw ex;
				} else {
					// To know error has happened
					// If object fail pass the validation, error Junit must
					// happen here
					Assert.assertNotEquals(
							ErrorCodeEnum.USERNAME_USED.getCode(),
							roleValidator.getErrors().get("username")
									.getCode());
				}

				roleService.insert(dataDelete);

			}
		} catch (Exception e) {
			e.printStackTrace();
			MatcherAssert.assertThat(e, Matchers.equalTo(null));

		} finally {
			roleService.closeDB();

		}
	}
}