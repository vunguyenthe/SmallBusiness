package com.small.business.model.user;

import com.small.business.model.base.BaseMessage;

public class UserFollowerNumber extends BaseMessage {
	private Long userId = 0L;
	private Long followerNumber = 0L;
	public Long getFollowerNumber() {
		return followerNumber;
	}
	public void setFollowerNumber(Long followerNumber) {
		this.followerNumber = followerNumber;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
}
