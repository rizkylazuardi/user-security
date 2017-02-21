package com.anabatic.usm.persistence.dao.impl.mybatis;

import org.springframework.stereotype.Service;

import com.anabatic.usm.persistence.dao.CoreRoleMapper;
import com.anabatic.usm.persistence.entity.CoreRole;

	@Service("coreRoleMapper")
	public  class CoreRoleMapperImpl extends GenericManagerImpl<Long,CoreRoleMapper , CoreRole>  implements CoreRoleMapper {
		
		public CoreRoleMapperImpl() {
			super(CoreRoleMapper.class);
		}

		@Override
		public CoreRole getRoleById(Object param) {
			this.openDB();
			CoreRole result =new CoreRole();
			try {
				result = dao.getRoleById(param);
		
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}finally{
				this.closeDB();
			}
			return result;
		}

		@Override
		public CoreRole getRoleByName(Object param) {
			this.openDB();
			CoreRole result =new CoreRole();
			try {
				result = dao.getRoleByName(param);
					} catch (Exception e) {
				e.printStackTrace();
				return null;
			}finally{
				this.closeDB();
			}
			return result;

		}		

		@Override
		public boolean updateById(Object param) {
			this.openDB();
			boolean result=true;
			try{
				result = dao.updateById(param);
			} catch (Exception e) {
				e.printStackTrace();
				return true;
			}finally{
				this.closeDB();
			}
			
			return result;
		}

		@Override
		public boolean updateSoftDelete(Object param) {
			this.openDB();
			boolean result=true;
			try{
				dao.updateSoftDelete(param);
			} catch (Exception e) {
				e.printStackTrace();
				
			}finally{
				this.closeDB();
			}
			return result;
				
		}
}

				
				

