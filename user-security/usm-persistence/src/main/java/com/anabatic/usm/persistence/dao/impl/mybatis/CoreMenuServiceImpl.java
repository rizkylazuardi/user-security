package com.anabatic.usm.persistence.dao.impl.mybatis;

import org.springframework.stereotype.Service;

import com.anabatic.usm.persistence.dao.CoreMenuMapper;
import com.anabatic.usm.persistence.entity.CoreMenu;

@Service
public class CoreMenuServiceImpl extends
		GenericManagerImpl<Long, CoreMenuMapper, CoreMenu> implements CoreMenuMapper {

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

	@Override
	public boolean deleteByDimas(Object param) {
		// TODO Auto-generated method stub
		return false;
	}
}	
	