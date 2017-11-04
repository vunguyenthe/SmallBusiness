package com.small.business.model.category;

import com.small.business.model.base.BaseMessage;

public class Category extends BaseMessage {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + "]";
	}
	
}
