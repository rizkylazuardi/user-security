package com.anabatic.usm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anabatic.usm.persistence.dao.CoreRoleMapper;
import com.anabatic.usm.persistence.entity.CoreRole;
import com.anabatic.usm.service.api.CoreRoleService;

	@Service("coreRoleService")
	public  class CoreRoleServiceImpl extends GenericManagerImpl<Long,CoreRoleMapper , CoreRole>  implements CoreRoleService {
		
		private CoreRoleMapper coreRoleMapper;
		
		@Autowired
		public void setCoreRoleMapper(CoreRoleMapper coreRoleMapper) {
			this.coreRoleMapper = coreRoleMapper;
			this.dao = coreRoleMapper;
		}
		
		
		@Override
		public CoreRole getRoleByID(Object param) {
			return coreRoleMapper.getRoleById(param);
		}

		@Override
		public CoreRole getRoleByName(Object param) {
			return coreRoleMapper.getRoleByName(param);

		}		

		@Override
		public boolean updateRoleById(Object param) {
			return coreRoleMapper.updateById(param);
		}

		@Override
		public boolean updateSoftDelete(Object param) {			
			return coreRoleMapper.updateSoftDelete(param);				
		}
}

				
				

