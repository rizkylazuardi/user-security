package com.anabatic.usm.service.impl;

import org.springframework.stereotype.Service;

import com.anabatic.usm.persistence.dao.RoleMapper;
import com.anabatic.usm.persistence.entity.CoreRole;
import com.anabatic.usm.service.api.RoleService;

	@Service("roleService")
	public  class RoleServiceImpl extends GenericManagerImpl<Long,RoleMapper , CoreRole>  implements RoleService {
		
		public RoleServiceImpl() {
			super(RoleMapper.class);
		}

		@Override
		public CoreRole getRoleByID(Object param) {
			CoreRole result =new CoreRole();
			try {
				result = dao.getRoleById(param);
		
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return result;
		}

		@Override
		public CoreRole getRoleByName(Object param) {
			// TODO Auto-generated method stub
			CoreRole result =new CoreRole();
			try {
				result = dao.getRoleByName(param);
					} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return result;

		}

	
		

		@Override
		public boolean updateRoleById(Object param) {
			// TODO Auto-generated method stub
		boolean result=true;
		try{
			result = dao.updateById(param);
		} catch (Exception e) {
	e.printStackTrace();
	return true;
		}
		
		return result;
			
			
			
			
			

		}

		@Override
		public boolean updateSoftDelete(Object param) {
			// TODO Auto-generated method stub
			boolean result=true;
			try{
				result = dao.updateSoftDelete(param);
			} catch (Exception e) {
		e.printStackTrace();
		return true;
			}
			
			return result;
				
		}
		

		
		}

				
				

