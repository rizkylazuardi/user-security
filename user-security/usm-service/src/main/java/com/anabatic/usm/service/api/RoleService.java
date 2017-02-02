package com.anabatic.usm.service.api;

import com.anabatic.usm.persistence.entity.CoreRole;

public interface RoleService extends GenericManager<CoreRole> {
public CoreRole getRoleByID (Object param);
public CoreRole getRoleByName (Object param);
public boolean updateRoleById (Object param);
public boolean updateSoftDelete (Object param);
}
