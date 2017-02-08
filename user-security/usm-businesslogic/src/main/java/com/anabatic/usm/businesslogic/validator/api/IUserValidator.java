package com.anabatic.usm.businesslogic.validator.api;

import com.anabatic.usm.businesslogic.validator.IValidator;
import com.anabatic.usm.persistence.entity.CoreUser;

public interface IUserValidator extends IValidator<CoreUser>{
	void validateEdit(CoreUser object);
	void validateDelete(CoreUser object);
}
