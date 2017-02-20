package com.anabatic.usm.businesslogic.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.anabatic.usm.businesslogic.validator.BaseValidator;
import com.anabatic.usm.businesslogic.validator.api.IRoleValidator;
import com.anabatic.usm.core.enumeration.ErrorCodeEnum;
import com.anabatic.usm.core.util.ErrorCode;
import com.anabatic.usm.persistence.entity.CoreRole;
import com.anabatic.usm.service.api.CoreRoleService;

@Component
public class RoleValidatorImpl extends BaseValidator<CoreRole> implements IRoleValidator {

	@Autowired
	private CoreRoleService roleService;
	
	@Override
	public void validateEdite(CoreRole object) {
		
	}

	@Override
	protected void validateObject(CoreRole object) {
		CoreRole role =roleService.getRoleByName(object.getName());
		if (role!=null){
			error.put("rolebyname", new ErrorCode(ErrorCodeEnum.USERNAME_USED.getCode(), 
					ErrorCodeEnum.USERNAME_USED.getDefaultMsg()));
		}
		
	}

	@Override
	public void validateDelete(CoreRole object) {
		// TODO Auto-generated method stub
		
	}

	


}		