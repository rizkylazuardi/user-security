package com.anabatic.usm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anabatic.usm.persistence.dao.CoreMenuMapper;
import com.anabatic.usm.persistence.entity.CoreMenu;
import com.anabatic.usm.service.api.CoreMenuService;


@Service("coreMenuService")
public class CoreMenuServiceImpl extends
		GenericManagerImpl<Long, CoreMenuMapper, CoreMenu> implements CoreMenuService {	
	
	
	private CoreMenuMapper coreMenuMapper;
	
	@Autowired
	public void setCoreMenuMapper(CoreMenuMapper coreMenuMapper) {
		this.coreMenuMapper = coreMenuMapper;
	}	

	@Override
	public CoreMenu getMenuById(Object param) {
		return coreMenuMapper.getMenuById(param);
	}

	@Override
	public CoreMenu getMenuByMenuCode(Object param) {
		return coreMenuMapper.getMenuByMenuCode(param);
	}

	@Override
	public CoreMenu getMenuByParent(Object param) {
		return coreMenuMapper.getMenuByParent(param);
	}

	@Override
	public boolean updateMenu(Object param) {
		return coreMenuMapper.updateMenu(param);		
	}

	@Override
	public boolean updateSoftDelete(Object param) {
		return coreMenuMapper.updateSoftDelete(param);
	}

	
}	
	