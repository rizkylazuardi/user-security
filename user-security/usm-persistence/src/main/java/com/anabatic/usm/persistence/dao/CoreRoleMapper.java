package com.anabatic.usm.persistence.dao;

import com.anabatic.usm.persistence.entity.CoreRole;

public interface CoreRoleMapper extends GenericMapper<CoreRole, Long> {

	public CoreRole getRoleById (Object param);
	public CoreRole getRoleByName (Object param);
	public boolean updateById(Object param);
	public boolean updateSoftDelete (Object param);
	}
