package com.anabatic.usm.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.anabatic.usm.persistence.dao.UserMapper;
import com.anabatic.usm.persistence.entity.CoreUser;
import com.anabatic.usm.service.api.UserService;

@Service
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

	@Override
	public CoreUser getByUsername(String username) {
		CoreUser user = new CoreUser();
		try{
			user = dao.getByUsername(username);
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public CoreUser getById(Long id) {
		CoreUser user = new CoreUser();
		try{
			user = dao.getById(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<CoreUser> getAllUser() {
		List<CoreUser> user = new ArrayList<CoreUser>();
		try{
			user = dao.getAllUser();
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}
		
	@Override
	public boolean userSoftDelete(Object param) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			result = dao.userSoftDelete(param);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
}
