package com.anabatic.usm.persistence.entity;

import com.anabatic.usm.persistence.annotation.TableAnnotation;

@TableAnnotation(tableName="core_menu")
public class CoreMenu extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 238819003146713792L;
	private Long id;			
	private String menuCode;			
	private String parentMenuCode;
	private String description;			
	private String title;			
	private String titleEn;			
	private Integer menuLevel;			
	private Integer menuOrder;			
	private String action;			
	private Long appid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getParentMenuCode() {
		return parentMenuCode;
	}
	public void setParentMenuCode(String parentMenuCode) {
		this.parentMenuCode = parentMenuCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitleEn() {
		return titleEn;
	}
	public void setTitleEn(String titleEn) {
		this.titleEn = titleEn;
	}
	public Integer getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}
	public Integer getMenuOrder() {
		return menuOrder;
	}
	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	public Long getAppid() {
		return appid;
	}
	public void setAppid(Long appid) {
		this.appid = appid;
	}
	
	
}
