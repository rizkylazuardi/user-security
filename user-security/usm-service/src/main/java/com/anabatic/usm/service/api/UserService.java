package com.anabatic.usm.service.api;

import java.util.List;

import com.anabatic.usm.persistence.entity.CoreRole;
import com.anabatic.usm.persistence.entity.CoreUser;

public interface UserService extends GenericManager<CoreUser>{
	public int getCountUser();
	
}
