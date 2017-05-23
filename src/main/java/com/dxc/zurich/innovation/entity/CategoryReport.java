package com.dxc.zurich.innovation.entity;

public class CategoryReport extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String categoryType = null;
	private String category = null;
	private String parentCategory = null;
	private Integer ideasCount = 0;
	
	public String getCategoryType() {
		return categoryType;
	}

	public String getCategory() {
		return category;
	}

	public String getParentCategory() {
		return parentCategory;
	}

	public Integer getIdeasCount() {
		return ideasCount;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setParentCategory(String parentCategory) {
		this.parentCategory = parentCategory;
	}

	public void setIdeasCount(Integer ideasCount) {
		this.ideasCount = ideasCount;
	}
}