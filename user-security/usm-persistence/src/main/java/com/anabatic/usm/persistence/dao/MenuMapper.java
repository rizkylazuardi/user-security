package com.anabatic.usm.persistence.dao;

import java.util.List;

import com.anabatic.usm.persistence.entity.CoreMenu;
import com.anabatic.usm.persistence.entity.CoreUser;

public interface MenuMapper  extends GenericMapper<CoreMenu, Long>{
	
	public CoreMenu getMenuById(Object param);
	public boolean updateMenuByDimas(Object param);
	public boolean deleteByDimas(Object param);
	public CoreMenu getMenuByMenuCode(Object param);
	public CoreMenu getMenuByParent(Object param);
	public boolean updateSoftDelete(Object param);
	
}
 