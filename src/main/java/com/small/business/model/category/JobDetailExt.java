package com.small.business.model.category;

import com.small.business.model.base.BaseMessage;

public class JobDetailExt extends BaseMessage {
	private long categoryDetailId;
	private String description;
	private double priceOrder;
	private String location;
	private float distance;
	private String datePost;
	private long iDatePost;
	@SuppressWarnings("unused")
	private String categoryDetailName;
	private String categoryName;
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

	public double getPriceOrder() {
		return priceOrder;
	}
	public void setPriceOrder(double priceOrder) {
		this.priceOrder = priceOrder;
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
	
	public String getCategoryDetailName() {
		return categoryDetailName;
	}
	public void setCategoryDetailName(String categoryDetailName) {
		this.categoryDetailName = categoryDetailName;
	}
	
	public long getiDatePost() {
		return iDatePost;
	}
	public void setiDatePost(long iDatePost) {
		this.iDatePost = iDatePost;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "JobDetail [categoryDetailId=" + categoryDetailId
				+ ", description=" + description + ", priceOder=" + priceOrder
				+ ", location=" + location + ", distance=" + distance
				+ ", datePost=" + datePost + "]";
	}
	
}
