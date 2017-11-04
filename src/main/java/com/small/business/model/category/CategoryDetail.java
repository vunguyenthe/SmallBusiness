package com.small.business.model.category;

import com.small.business.model.base.BaseMessage;

public class CategoryDetail extends BaseMessage {
	private Long categoryId;
	private String name;
	private String categoryName;	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + "]";
	}
	
}
