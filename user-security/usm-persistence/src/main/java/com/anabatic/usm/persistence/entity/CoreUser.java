package com.anabatic.usm.persistence.entity;


import com.anabatic.usm.persistence.annotation.IdentityAnnotation;
import com.anabatic.usm.persistence.annotation.TableAnnotation;



@TableAnnotation(tableName="core_user")
public class CoreUser extends GenericObject{
	private static final long serialVersionUID = 355427026819625452L;
	private Long id;
	private String userid;
	private int isActive;
	private int isLogin;
	private Boolean showBalance = false;
	private String language;
	
	@IdentityAnnotation(isGenerateValue=false,fieldName="id")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getIsLogin() {
		return isLogin;
	}

	public void setIsLogin(int isLogin) {
		this.isLogin = isLogin;
	}

	@Override
	public String toString() {
		return "CoreUser [id=" + id + ", userid=" + userid + ", isActive="
				+ isActive + ", isLogin=" + isLogin + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + isActive;
		result = prime * result + isLogin;
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoreUser other = (CoreUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActive != other.isActive)
			return false;
		if (isLogin != other.isLogin)
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}

	public Boolean getShowBalance() {
		return showBalance;
	}

	public void setShowBalance(Boolean showBalance) {
		this.showBalance = showBalance;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	

}
