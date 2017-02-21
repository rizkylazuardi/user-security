package com.anabatic.usm.persistence.dao.impl.mybatis;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.anabatic.usm.persistence.dao.CoreUserMapper;
import com.anabatic.usm.persistence.entity.CoreUser;

@Component
public class CoreUserServiceImpl extends GenericManagerImpl<Long,CoreUserMapper , CoreUser>  implements CoreUserMapper {
	
	public CoreUserServiceImpl() {
		super(CoreUserMapper.class);
	}

	public int getCountUser() {
		int result = 0;
		try{
			openDB();
			result = dao.getCountUser();
			closeDB();
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

	@Override
	public boolean updateCoreUser() {
		// TODO Auto-generated method stub
		return false;
	}
}
