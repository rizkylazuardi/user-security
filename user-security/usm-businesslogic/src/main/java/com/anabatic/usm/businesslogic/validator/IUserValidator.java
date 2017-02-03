package com.anabatic.usm.businesslogic.validator;

import com.anabatic.usm.persistence.entity.CoreUser;

public interface IUserValidator extends IValidator<CoreUser>{
	void validateEdit(CoreUser object);
}
