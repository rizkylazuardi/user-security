package com.anabatic.usm.persistence.dao.impl.mybatis;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.anabatic.usm.persistence.dao.CoreUserMapper;
import com.anabatic.usm.persistence.entity.CoreUser;

@Service("coreUserMapper")
public class CoreUserMapperImpl extends GenericManagerImpl<Long,CoreUserMapper , CoreUser>  implements CoreUserMapper {
	
	public CoreUserMapperImpl() {
		super(CoreUserMapper.class);
	}

	public int getCountUser() {
		this.openDB();
		int result = 0;
		try{
			openDB();
			result = dao.getCountUser();
			closeDB();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closeDB();
		}
		return result;
	}

	@Override
	public CoreUser getByUsername(String username) {
		this.openDB();
		CoreUser user = new CoreUser();
		try{
			user = dao.getByUsername(username);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closeDB();
		}
		return user;
	}

	@Override
	public CoreUser getById(Long id) {
		this.openDB();
		CoreUser user = new CoreUser();
		try{
			user = dao.getById(id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closeDB();
		}
		return user;
	}

	@Override
	public List<CoreUser> getAllUser() {
		this.openDB();
		List<CoreUser> user = new ArrayList<CoreUser>();
		try{
			user = dao.getAllUser();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closeDB();
		}
		return user;
	}
		
	@Override
	public boolean userSoftDelete(Object param) {
		// TODO Auto-generated method stub
		boolean result = false;
		this.openDB();
		try {
			result = dao.userSoftDelete(param);
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}finally{
			this.closeDB();
		}
		return result;
	}

	@Override
	public boolean updateCoreUser() {
		// TODO Auto-generated method stub
		return false;
	}
}
