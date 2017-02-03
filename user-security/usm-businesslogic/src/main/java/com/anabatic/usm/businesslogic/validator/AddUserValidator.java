/**
 * 
 */
package com.anabatic.usm.businesslogic.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.anabatic.usm.persistence.entity.CoreUser;
import com.anabatic.usm.service.api.UserService;

/**
 * @author ahlul.esasjana
 *
 */
@Component
public class AddUserValidator extends BaseValidator<CoreUser> implements IUserValidator{

	@Autowired@Qualifier("userService")
	private UserService userService;
	
	@Override
	protected void validateObject(CoreUser object) {
		
	}

	@Override
	protected void validateDel(CoreUser object) {
		
	}

	@Override
	public void validateEdit() {
		
	}
	
	

}
