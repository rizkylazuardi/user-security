package com.anabatic.usm.persistence.dao;

import com.anabatic.usm.persistence.entity.CoreMenu;

public interface CoreMenuMapper  extends GenericMapper<CoreMenu, Long>{
	
	public CoreMenu getMenuById(Object param);
	public boolean updateMenu(Object param);
	public boolean deleteByDimas(Object param);
	public CoreMenu getMenuByMenuCode(Object param);
	public CoreMenu getMenuByParent(Object param);
	public boolean updateSoftDelete(Object param);
	
}
 