package com.anabatic.usm.service.impl;
import org.springframework.stereotype.Service;

import com.anabatic.usm.persistence.dao.UserMapper;
import com.anabatic.usm.persistence.entity.CoreUser;
import com.anabatic.usm.service.api.UserService;

@Service("userService")
public class UserServiceImpl extends GenericManagerImpl<Long,UserMapper , CoreUser>  implements UserService {
	
	public UserServiceImpl() {
		super(UserMapper.class);
	}

	public int getCountUser() {
		int result = 0;
		try{
			result = dao.getCountUser();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
}