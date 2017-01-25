package com.anabatic.usm.persistence.entity;

public class SecurityQuestion extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6506134407877543658L;
	private Long id;
	private String question;
	private boolean custom;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public boolean isCustom() {
		return custom;
	}
	public void setCustom(boolean custom) {
		this.custom = custom;
	}
	
	
}
