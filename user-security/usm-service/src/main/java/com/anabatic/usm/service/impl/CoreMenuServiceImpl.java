package com.anabatic.usm.service.impl;

import org.springframework.stereotype.Service;

import com.anabatic.usm.persistence.dao.CoreMenuMapper;
import com.anabatic.usm.persistence.dao.CoreUserMapper;
import com.anabatic.usm.persistence.entity.CoreMenu;
import com.anabatic.usm.persistence.entity.CoreUser;
import com.anabatic.usm.service.api.CoreMenuService;
import com.anabatic.usm.service.api.UserService;

@Service
public class CoreMenuServiceImpl extends
		GenericManagerImpl<Long, CoreMenuMapper, CoreMenu> implements CoreMenuService {

	public CoreMenuServiceImpl() {
		super(CoreMenuMapper.class);
	}

	@Override
	public CoreMenu getMenuById(Object param) {
		CoreMenu result = new CoreMenu();
		try {
			result = dao.getMenuById(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public CoreMenu getMenuByMenuCode(Object param) {
		// TODO Auto-generated method stub
		CoreMenu result = new CoreMenu();
		try {
			result = dao.getMenuByMenuCode(param);
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
		return result;

	}

	@Override
	public CoreMenu getMenuByParent(Object param) {
		// TODO Auto-generated method stub
		CoreMenu result = new CoreMenu();
		try {
			result = dao.getMenuByParent(param);
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
		return result;

	}

	@Override
	public boolean updateMenu(Object param) {
		// TODO Auto-generated method stub
		boolean result = true;
		try {
			result = dao.updateMenu(param);
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
		return result;
		
	}


	@Override
	public boolean updateSoftDelete(Object param) {
		// TODO Auto-generated method stub
		boolean result = true;
		try {
			result = dao.updateSoftDelete(param);
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
		return result;
	}
}	
	