package com.anabatic.usm.service.api;

import com.anabatic.usm.persistence.entity.CoreMenu;

public interface MenuService extends GenericManager<CoreMenu>{
	public CoreMenu getMenuById (Object param);
	public CoreMenu getMenuByMenuCode(Object param);
	public CoreMenu getMenuByParent(Object param);
	public boolean updateMenu(Object param);
	public boolean updateSoftDelete(Object param);
	}
