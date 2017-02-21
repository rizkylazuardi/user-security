package com.anabatic.usm.persistence.dao.impl.mybatis;

import org.springframework.stereotype.Service;

import com.anabatic.usm.persistence.dao.CoreRoleMapper;
import com.anabatic.usm.persistence.entity.CoreRole;

	@Service
	public  class CoreRoleServiceImpl extends GenericManagerImpl<Long,CoreRoleMapper , CoreRole>  implements CoreRoleMapper {
		
		public CoreRoleServiceImpl() {
			super(CoreRoleMapper.class);
		}

		@Override
		public CoreRole getRoleById(Object param) {
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
		public boolean updateById(Object param) {
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

				
				

