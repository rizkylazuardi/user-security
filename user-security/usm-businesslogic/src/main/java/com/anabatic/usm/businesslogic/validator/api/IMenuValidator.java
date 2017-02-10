package com.anabatic.usm.businesslogic.validator.api;

import com.anabatic.usm.businesslogic.validator.IValidator;
import com.anabatic.usm.persistence.entity.CoreMenu;

public interface IMenuValidator extends IValidator<CoreMenu>{
	void validateEdite(CoreMenu object);

}
