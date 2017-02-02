package com.anabatic.usm.persistence.entity;

<<<<<<< HEAD
=======
import com.anabatic.usm.persistence.annotation.TableAnnotation;

@TableAnnotation(tableName="core_role")
>>>>>>> origin/master
public class CoreRole extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4678750719114566289L;
	private Long id;
	private String name;
	private String description;
	private String description_en;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription_en(String description_en) {
		return description_en;
	}
	public void setDescription_en(String description_en) {
		this.description_en = description_en;
	}
	
	}
	
	

