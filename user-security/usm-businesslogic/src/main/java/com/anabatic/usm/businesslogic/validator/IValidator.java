/**
 * 
 */
package com.anabatic.usm.businesslogic.validator;

import java.util.Map;

import com.anabatic.usm.core.util.ErrorCode;

/**
 * @author ahlul.esasjana
 * from PocketValidator Pocket Core
 */

public interface IValidator<T> {
	public void validate(T object);
	public boolean hasError();
	public Map<String, ErrorCode> getErrors();
	public boolean validateCode(String input);
}
