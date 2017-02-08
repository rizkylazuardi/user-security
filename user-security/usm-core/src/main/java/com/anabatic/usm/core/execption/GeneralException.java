/**
 * 
 */
package com.anabatic.usm.core.execption;

import org.apache.commons.lang.StringUtils;

import com.anabatic.usm.core.enumeration.ErrorCodeEnum;

/**
 * @author ahlul.esasjana
 * from GeneralException Pocket Core
 */
public class GeneralException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7584896013607926674L;
	
	protected String errorKey;
	protected ErrorCodeEnum errorCode;
	
	public GeneralException(String message) {
        super(message);
    }

	public GeneralException(Throwable throwable) {
		super(throwable);
	}
	
    public GeneralException(String message, Throwable throwable) {
        super(message, throwable);
    }
    
    public GeneralException(String errorCode, String message) {
    	super(StringUtils.trimToNull(errorCode)!=null ? errorCode +" : "+message : message);
    	this.errorKey = errorCode;
    }
    
    public GeneralException(String errorCode, String message, Throwable throwable) {
    	super(StringUtils.trimToNull(errorCode)!=null ? errorCode +" : "+message : message, throwable);
    	this.errorKey = errorCode;
    }
    
    /**Declare exception as error code message
     * @param errorCode error code that should provided
     */
	public GeneralException(ErrorCodeEnum errorCode) {
		super(StringUtils.trimToNull(errorCode.getCode())!=null ? errorCode.getCode()+" : "+errorCode.getDefaultMsg() : errorCode.getDefaultMsg());
		this.errorCode = errorCode;
	}
	
	/**Declare exception as error code message, and a message to override default message from {@link ErrorCodeEnum}
     * @param errorCode error code that should provided
     * @param message override message
     */
	public GeneralException(ErrorCodeEnum errorCode, String message) {
		super(StringUtils.trimToNull(errorCode.getCode())!=null ? errorCode.getCode()+" : "+message : message);
		this.errorCode = errorCode;
		this.errorCode.setDefaultMsg(message);
	}
	
	public ErrorCodeEnum getErrorCode() {
		return errorCode;
	}

	public String getErrorKey() {
		return errorKey;
	}

	public void setErrorKey(String errorKey) {
		this.errorKey = errorKey;
	}
}
