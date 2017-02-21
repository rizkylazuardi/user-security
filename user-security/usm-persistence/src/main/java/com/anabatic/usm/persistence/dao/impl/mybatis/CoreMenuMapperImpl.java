package com.anabatic.usm.persistence.dao.impl.mybatis;

import org.springframework.stereotype.Service;

import com.anabatic.usm.persistence.dao.CoreMenuMapper;
import com.anabatic.usm.persistence.entity.CoreMenu;

@Service("coreMenuMapper")
public class CoreMenuMapperImpl extends
		GenericManagerImpl<Long, CoreMenuMapper, CoreMenu> implements CoreMenuMapper {

	public CoreMenuMapperImpl() {
		super(CoreMenuMapper.class);
	}

	@Override
	public CoreMenu getMenuById(Object param) {
		this.openDB();
		CoreMenu result = new CoreMenu();
		try {
			result = dao.getMenuById(param);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeDB();
		}
		return result;
	}

	@Override
	public CoreMenu getMenuByMenuCode(Object param) {
		this.openDB();
		CoreMenu result = new CoreMenu();
		try {
			result = dao.getMenuByMenuCode(param);
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}finally{
			this.closeDB();
		}
		return result;

	}

	@Override
	public CoreMenu getMenuByParent(Object param) {
		this.openDB();
		CoreMenu result = new CoreMenu();
		try {
			result = dao.getMenuByParent(param);
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}finally{
			this.closeDB();
		}
		return result;

	}

	@Override
	public boolean updateMenu(Object param) {
		this.openDB();
		boolean result = true;
		try {
			result = dao.updateMenu(param);
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}finally{
			this.closeDB();
		}
		return result;
		
	}


	@Override
	public boolean updateSoftDelete(Object param) {
		this.openDB();
		boolean result = true;
		try {
			result = dao.updateSoftDelete(param);
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}finally{
			this.closeDB();
		}
		return result;
	}
}	
	