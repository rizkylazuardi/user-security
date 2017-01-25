package com.anabatic.usm.persistence.dao;

import java.util.List;

import com.anabatic.usm.persistence.entity.CoreRole;

public interface RoleMapper extends GenericMapper<CoreRole, Long> {

	public CoreRole getRoleById (Object param);
}

