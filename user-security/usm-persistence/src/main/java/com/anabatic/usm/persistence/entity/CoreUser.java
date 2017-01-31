package com.anabatic.usm.persistence.entity;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.anabatic.usm.core.enumeration.SecurityQuestionEnum;
import com.anabatic.usm.persistence.annotation.IdentityAnnotation;
import com.anabatic.usm.persistence.annotation.TableAnnotation;



@TableAnnotation(tableName="core_user")
public class CoreUser extends BaseModel{
	private static final long serialVersionUID = 355427026819625452L;
	 private Long id;
	    private String username;
	    private String password;
	    private String confirmPassword;
	    private String passwordSalt;
	    private String personnelCode;
	    private String firstName;
	    private String middleName;
	    private String lastName;
	    private String email;
	    private Date lastLogon=new Date();
	    private Date lastFailedLogon=new Date();
	    private Date lastBlocked=new Date();
	    private Date lastChangePassword=new Date();
		private String passwordHint;
		private String msisdn;
	    private Long sessionTimeout = 0L;
	    private boolean accountEnabled = false;
	    private boolean accountNonExpired = false;
	    private boolean accountNonLocked = true;
	    private boolean credentialsNonExpired = true;
	    private boolean isActivated = false;
	    private Date activated_date;
	    
		private SecurityQuestionEnum secQuestion;
		private String secAnswer;
		
	    private Set<CustomerSecurityQuestion> securityQuestions;
		
		private Set<CoreRole> roles = new HashSet<CoreRole>();
	  //  private Set<CoreBranch> branches = new HashSet<CoreBranch>();
	    private CoreRole activeRole;
	    private String preferredLocale;
	    private Integer loginAttempt = 0;
	    private String ipAddress;
		private String session;
		private String activeBranch;
		private String oldPassword;
		private String newPassword;
		private String confirmNewPassword;
		private String facebook;
		//private List<TrxUserDeviceMapping> deviceMapping = new ArrayList<TrxUserDeviceMapping>();
	
	@IdentityAnnotation(isGenerateValue=false,fieldName="id")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	public String getPersonnelCode() {
		return personnelCode;
	}

	public void setPersonnelCode(String personnelCode) {
		this.personnelCode = personnelCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLastLogon() {
		return lastLogon;
	}

	public void setLastLogon(Date lastLogon) {
		this.lastLogon = lastLogon;
	}

	public Date getLastFailedLogon() {
		return lastFailedLogon;
	}

	public void setLastFailedLogon(Date lastFailedLogon) {
		this.lastFailedLogon = lastFailedLogon;
	}

	public Date getLastBlocked() {
		return lastBlocked;
	}

	public void setLastBlocked(Date lastBlocked) {
		this.lastBlocked = lastBlocked;
	}

	public Date getLastChangePassword() {
		return lastChangePassword;
	}

	public void setLastChangePassword(Date lastChangePassword) {
		this.lastChangePassword = lastChangePassword;
	}

	public String getPasswordHint() {
		return passwordHint;
	}

	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public Long getSessionTimeout() {
		return sessionTimeout;
	}

	public void setSessionTimeout(Long sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}

	public boolean isAccountEnabled() {
		return accountEnabled;
	}

	public void setAccountEnabled(boolean accountEnabled) {
		this.accountEnabled = accountEnabled;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public Date getActivated_date() {
		return activated_date;
	}

	public void setActivated_date(Date activated_date) {
		this.activated_date = activated_date;
	}

	public SecurityQuestionEnum getSecQuestion() {
		return secQuestion;
	}

	public void setSecQuestion(SecurityQuestionEnum secQuestion) {
		this.secQuestion = secQuestion;
	}

	public String getSecAnswer() {
		return secAnswer;
	}

	public void setSecAnswer(String secAnswer) {
		this.secAnswer = secAnswer;
	}

	public Set<CustomerSecurityQuestion> getSecurityQuestions() {
		return securityQuestions;
	}

	public void setSecurityQuestions(Set<CustomerSecurityQuestion> securityQuestions) {
		this.securityQuestions = securityQuestions;
	}

	public Set<CoreRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<CoreRole> roles) {
		this.roles = roles;
	}

	public CoreRole getActiveRole() {
		return activeRole;
	}

	public void setActiveRole(CoreRole activeRole) {
		this.activeRole = activeRole;
	}

	public String getPreferredLocale() {
		return preferredLocale;
	}

	public void setPreferredLocale(String preferredLocale) {
		this.preferredLocale = preferredLocale;
	}

	public Integer getLoginAttempt() {
		return loginAttempt;
	}

	public void setLoginAttempt(Integer loginAttempt) {
		this.loginAttempt = loginAttempt;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getActiveBranch() {
		return activeBranch;
	}

	public void setActiveBranch(String activeBranch) {
		this.activeBranch = activeBranch;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}

	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	
}
