package com.anabatic.usm.persistence.entity;
/*
 * User's entity
 */
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.anabatic.usm.core.enumeration.SecurityQuestionEnum;
import com.anabatic.usm.persistence.annotation.IdentityAnnotation;
import com.anabatic.usm.persistence.annotation.TableAnnotation;

@TableAnnotation(tableName = "core_user")
public class CoreUser extends BaseModel {
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
	private Date lastLogon = new Date();
	private Date lastFailedLogon = new Date();
	private Date lastBlocked = new Date();
	private Date lastChangePassword = new Date();
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

	@IdentityAnnotation(isGenerateValue = false, fieldName = "id")
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

	@Override
	public String toString() {
		return "CoreUser [id=" + id + ", username=" + username + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", passwordSalt=" + passwordSalt + ", personnelCode=" + personnelCode
				+ ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", email="
				+ email + ", lastLogon=" + lastLogon + ", lastFailedLogon=" + lastFailedLogon + ", lastBlocked="
				+ lastBlocked + ", lastChangePassword=" + lastChangePassword + ", passwordHint=" + passwordHint
				+ ", msisdn=" + msisdn + ", sessionTimeout=" + sessionTimeout + ", accountEnabled=" + accountEnabled
				+ ", accountNonExpired=" + accountNonExpired + ", accountNonLocked=" + accountNonLocked
				+ ", credentialsNonExpired=" + credentialsNonExpired + ", isActivated=" + isActivated
				+ ", activated_date=" + activated_date + ", secQuestion=" + secQuestion + ", secAnswer=" + secAnswer
				+ ", securityQuestions=" + securityQuestions + ", roles=" + roles + ", activeRole=" + activeRole
				+ ", preferredLocale=" + preferredLocale + ", loginAttempt=" + loginAttempt + ", ipAddress=" + ipAddress
				+ ", session=" + session + ", activeBranch=" + activeBranch + ", oldPassword=" + oldPassword
				+ ", newPassword=" + newPassword + ", confirmNewPassword=" + confirmNewPassword + ", facebook="
				+ facebook + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (accountEnabled ? 1231 : 1237);
		result = prime * result + (accountNonExpired ? 1231 : 1237);
		result = prime * result + (accountNonLocked ? 1231 : 1237);
		result = prime * result + ((activated_date == null) ? 0 : activated_date.hashCode());
		result = prime * result + ((activeBranch == null) ? 0 : activeBranch.hashCode());
		result = prime * result + ((activeRole == null) ? 0 : activeRole.hashCode());
		result = prime * result + ((confirmNewPassword == null) ? 0 : confirmNewPassword.hashCode());
		result = prime * result + ((confirmPassword == null) ? 0 : confirmPassword.hashCode());
		result = prime * result + (credentialsNonExpired ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((facebook == null) ? 0 : facebook.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ipAddress == null) ? 0 : ipAddress.hashCode());
		result = prime * result + (isActivated ? 1231 : 1237);
		result = prime * result + ((lastBlocked == null) ? 0 : lastBlocked.hashCode());
		result = prime * result + ((lastChangePassword == null) ? 0 : lastChangePassword.hashCode());
		result = prime * result + ((lastFailedLogon == null) ? 0 : lastFailedLogon.hashCode());
		result = prime * result + ((lastLogon == null) ? 0 : lastLogon.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((loginAttempt == null) ? 0 : loginAttempt.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
		result = prime * result + ((newPassword == null) ? 0 : newPassword.hashCode());
		result = prime * result + ((oldPassword == null) ? 0 : oldPassword.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((passwordHint == null) ? 0 : passwordHint.hashCode());
		result = prime * result + ((passwordSalt == null) ? 0 : passwordSalt.hashCode());
		result = prime * result + ((personnelCode == null) ? 0 : personnelCode.hashCode());
		result = prime * result + ((preferredLocale == null) ? 0 : preferredLocale.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((secAnswer == null) ? 0 : secAnswer.hashCode());
		result = prime * result + ((secQuestion == null) ? 0 : secQuestion.hashCode());
		result = prime * result + ((securityQuestions == null) ? 0 : securityQuestions.hashCode());
		result = prime * result + ((session == null) ? 0 : session.hashCode());
		result = prime * result + ((sessionTimeout == null) ? 0 : sessionTimeout.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoreUser other = (CoreUser) obj;
		if (accountEnabled != other.accountEnabled)
			return false;
		if (accountNonExpired != other.accountNonExpired)
			return false;
		if (accountNonLocked != other.accountNonLocked)
			return false;
		if (activated_date == null) {
			if (other.activated_date != null)
				return false;
		} else if (!activated_date.equals(other.activated_date))
			return false;
		if (activeBranch == null) {
			if (other.activeBranch != null)
				return false;
		} else if (!activeBranch.equals(other.activeBranch))
			return false;
		if (activeRole == null) {
			if (other.activeRole != null)
				return false;
		} else if (!activeRole.equals(other.activeRole))
			return false;
		if (confirmNewPassword == null) {
			if (other.confirmNewPassword != null)
				return false;
		} else if (!confirmNewPassword.equals(other.confirmNewPassword))
			return false;
		if (confirmPassword == null) {
			if (other.confirmPassword != null)
				return false;
		} else if (!confirmPassword.equals(other.confirmPassword))
			return false;
		if (credentialsNonExpired != other.credentialsNonExpired)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (facebook == null) {
			if (other.facebook != null)
				return false;
		} else if (!facebook.equals(other.facebook))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ipAddress == null) {
			if (other.ipAddress != null)
				return false;
		} else if (!ipAddress.equals(other.ipAddress))
			return false;
		if (isActivated != other.isActivated)
			return false;
		if (lastBlocked == null) {
			if (other.lastBlocked != null)
				return false;
		} else if (!lastBlocked.equals(other.lastBlocked))
			return false;
		if (lastChangePassword == null) {
			if (other.lastChangePassword != null)
				return false;
		} else if (!lastChangePassword.equals(other.lastChangePassword))
			return false;
		if (lastFailedLogon == null) {
			if (other.lastFailedLogon != null)
				return false;
		} else if (!lastFailedLogon.equals(other.lastFailedLogon))
			return false;
		if (lastLogon == null) {
			if (other.lastLogon != null)
				return false;
		} else if (!lastLogon.equals(other.lastLogon))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (loginAttempt == null) {
			if (other.loginAttempt != null)
				return false;
		} else if (!loginAttempt.equals(other.loginAttempt))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
			return false;
		if (newPassword == null) {
			if (other.newPassword != null)
				return false;
		} else if (!newPassword.equals(other.newPassword))
			return false;
		if (oldPassword == null) {
			if (other.oldPassword != null)
				return false;
		} else if (!oldPassword.equals(other.oldPassword))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (passwordHint == null) {
			if (other.passwordHint != null)
				return false;
		} else if (!passwordHint.equals(other.passwordHint))
			return false;
		if (passwordSalt == null) {
			if (other.passwordSalt != null)
				return false;
		} else if (!passwordSalt.equals(other.passwordSalt))
			return false;
		if (personnelCode == null) {
			if (other.personnelCode != null)
				return false;
		} else if (!personnelCode.equals(other.personnelCode))
			return false;
		if (preferredLocale == null) {
			if (other.preferredLocale != null)
				return false;
		} else if (!preferredLocale.equals(other.preferredLocale))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (secAnswer == null) {
			if (other.secAnswer != null)
				return false;
		} else if (!secAnswer.equals(other.secAnswer))
			return false;
		if (secQuestion != other.secQuestion)
			return false;
		if (securityQuestions == null) {
			if (other.securityQuestions != null)
				return false;
		} else if (!securityQuestions.equals(other.securityQuestions))
			return false;
		if (session == null) {
			if (other.session != null)
				return false;
		} else if (!session.equals(other.session))
			return false;
		if (sessionTimeout == null) {
			if (other.sessionTimeout != null)
				return false;
		} else if (!sessionTimeout.equals(other.sessionTimeout))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	

}
