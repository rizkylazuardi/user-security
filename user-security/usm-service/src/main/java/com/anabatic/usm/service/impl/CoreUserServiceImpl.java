package com.anabatic.usm.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anabatic.usm.persistence.dao.CoreUserMapper;
import com.anabatic.usm.persistence.entity.CoreUser;
import com.anabatic.usm.service.api.CoreUserService;

@Service
public class CoreUserServiceImpl extends GenericManagerImpl<Long,CoreUserMapper , CoreUser>  implements CoreUserService {
	
	private CoreUserMapper coreUserMapper;
	
	@Autowired
	public void setCoreUserMapper(CoreUserMapper coreUserMapper) {
		this.coreUserMapper = coreUserMapper;
		this.dao = coreUserMapper;
	}
	
	public int getCountUser() {
		return coreUserMapper.getCountUser();
	}

	@Override
	public CoreUser getByUsername(String username) {
		return coreUserMapper.getByUsername(username);
	}

	@Override
	public CoreUser getById(Long id) {
		return coreUserMapper.getById(id);
	}

	@Override
	public List<CoreUser> getAllUser() {
		return coreUserMapper.getAllUser();
	}
		
	@Override
	public boolean userSoftDelete(Object param) {
		return coreUserMapper.userSoftDelete(param);
	}

	
}
