package com.small.business.model.category;

import com.small.business.model.base.BaseMessage;

public class JobDetail extends BaseMessage {
	private long categoryDetailId;
	private String description;
	private double priceOrder;
	private String location;
	private float distance;
	private String datePost;
	public long getCategoryDetailId() {
		return categoryDetailId;
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
		return "JobDetail [categoryDetailId=" + categoryDetailId
				+ ", description=" + description + ", priceOder=" + priceOrder
				+ ", location=" + location + ", distance=" + distance
				+ ", datePost=" + datePost + "]";
	}
	
}
