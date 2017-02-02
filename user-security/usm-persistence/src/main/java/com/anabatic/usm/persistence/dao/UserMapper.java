package com.anabatic.usm.persistence.dao;

import com.anabatic.usm.persistence.entity.CoreUser;

	

public interface UserMapper extends GenericMapper<CoreUser, Long>{
	public int getCountUser();
	public CoreUser getByUsername(String username);
	public CoreUser getById(Long id);
	public void userSoftDelete(Long id);
}
