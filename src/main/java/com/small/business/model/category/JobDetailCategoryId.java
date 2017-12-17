package com.small.business.model.category;

import com.small.business.model.base.BaseMessage;

public class JobDetailCategoryId extends BaseMessage {
	private long  employerId = 0L;
	private long categoryDetailId = 0L;
	private long categoryId = 0L;
	private String description;
	private double priceOrder = 0f;
	private String location;
	private float distance = 0f;
	private String datePost;
	private Long iDatePost = 0L;
	public long getCategoryDetailId() {
		return categoryDetailId;
	}
	
	public long getEmployerId() {
		return employerId;
	}

	public void setEmployerId(long employerId) {
		this.employerId = employerId;
	}

	public Long getiDatePost() {
		return iDatePost;
	}

	public void setiDatePost(Long iDatePost) {
		this.iDatePost = iDatePost;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public void setCategoryDetailId(long categoryDetailId) {
		this.categoryDetailId = categoryDetailId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public String getDatePost() {
		return datePost;
	}
	public void setDatePost(String datePost) {
		this.datePost = datePost;
	}
	
	public double getPriceOrder() {
		return priceOrder;
	}
	public void setPriceOrder(double priceOrder) {
		this.priceOrder = priceOrder;
	}

	@Override
	public String toString() {
		return "JobDetailCategoryId [employerId=" + employerId
				+ ", categoryDetailId=" + categoryDetailId + ", categoryId="
				+ categoryId + ", description=" + description + ", priceOrder="
				+ priceOrder + ", location=" + location + ", distance="
				+ distance + ", datePost=" + datePost + ", iDatePost="
				+ iDatePost + "]";
	}
	
}
