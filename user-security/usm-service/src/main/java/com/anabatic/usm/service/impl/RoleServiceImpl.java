package com.anabatic.usm.service.impl;

import org.springframework.stereotype.Service;

import com.anabatic.usm.persistence.dao.RoleMapper;
import com.anabatic.usm.persistence.entity.CoreRole;
import com.anabatic.usm.service.api.RoleService;

	@Service("RoleService")
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
}
