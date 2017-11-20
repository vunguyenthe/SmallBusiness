package com.small.business.model.bidjob;

import com.small.business.model.base.BaseMessage;

public class UserRateInfo extends BaseMessage {
	private Long userId = 0L;
	private int level;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "UserRateInfo [userId=" + userId + ", level=" + level + "]";
	}
	
}
