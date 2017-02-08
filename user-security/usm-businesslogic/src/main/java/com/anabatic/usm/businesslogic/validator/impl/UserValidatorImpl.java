/**
 * 
 */
package com.anabatic.usm.businesslogic.validator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.anabatic.usm.businesslogic.validator.BaseValidator;
import com.anabatic.usm.businesslogic.validator.api.IUserValidator;
import com.anabatic.usm.core.enumeration.ErrorCodeEnum;
import com.anabatic.usm.core.execption.GeneralException;
import com.anabatic.usm.core.util.ErrorCode;
import com.anabatic.usm.persistence.entity.CoreUser;
import com.anabatic.usm.service.api.UserService;

/**
 * @author ahlul.esasjana
 *
 */
@Component
public class UserValidatorImpl extends BaseValidator<CoreUser> implements IUserValidator{

	@Autowired@Qualifier("userService")
	private UserService userService;
	
	@Override
	protected void validateObject(CoreUser object) {
			userService.openDB();
			CoreUser user = userService.getByUsername(object.getUsername());
			if(user!=null){
				error.put("username", new ErrorCode(ErrorCodeEnum.USERNAME_USED.getCode(), 
						ErrorCodeEnum.USERNAME_USED.getDefaultMsg()));
			}
		
	}

	@Override
	public void validateEdit(CoreUser object) {
		
	}

}
