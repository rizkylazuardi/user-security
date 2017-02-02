package com.anabatic.usm.service.api;

import com.anabatic.usm.persistence.entity.CoreUser;

public interface UserService extends GenericManager<CoreUser>{
	public int getCountUser();
	public CoreUser getByUsername(String username);
	public CoreUser getById(Long id);
	public void userSoftDelete(Long id);
}
