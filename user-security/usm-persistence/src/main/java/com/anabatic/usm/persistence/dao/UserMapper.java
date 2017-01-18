package com.anabatic.usm.persistence.dao;

import com.anabatic.usm.persistence.entity.CoreUser;



public interface UserMapper extends GenericMapper<CoreUser, Long>{
	public int getCountUser();
}
