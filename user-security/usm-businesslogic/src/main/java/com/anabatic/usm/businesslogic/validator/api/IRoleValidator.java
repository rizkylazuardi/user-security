package com.anabatic.usm.businesslogic.validator.api;

import com.anabatic.usm.businesslogic.validator.IValidator;
import com.anabatic.usm.persistence.entity.CoreMenu;
import com.anabatic.usm.persistence.entity.CoreRole;

public interface IRoleValidator extends IValidator <CoreRole> {
	void validateEdite(CoreRole object);
}
