package com.anabatic.usm.persistence.entity;

public class CustomerSecurityQuestion extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4160492907578092072L;
	private Long id;
	private SecurityQuestion question;
	private String answer;
	private CoreUser user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public SecurityQuestion getQuestion() {
		return question;
	}
	public void setQuestion(SecurityQuestion question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public CoreUser getUser() {
		return user;
	}
	public void setUser(CoreUser user) {
		this.user = user;
	}
	
	
}
