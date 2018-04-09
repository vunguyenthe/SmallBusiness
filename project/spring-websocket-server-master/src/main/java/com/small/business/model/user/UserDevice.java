package com.small.business.model.user;

import com.small.business.model.base.BaseMessage;

public class UserDevice extends BaseMessage {
	private Long userId = 0L;
	private String uuid = "";
	private String token = "";
	private String registeredDay = "";
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRegisteredDay() {
		return registeredDay;
	}
	public void setRegisteredDay(String registeredDay) {
		this.registeredDay = registeredDay;
	}
	
}
