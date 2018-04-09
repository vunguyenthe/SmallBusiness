package com.small.business.model.user;

import com.small.business.model.base.BaseMessage;

public class UserFollowingNumber extends BaseMessage {
	private Long userId = 0L;
	private Long followingNumber = 0L;
	public Long getFollowingNumber() {
		return followingNumber;
	}
	public void setFollowingNumber(Long followerNumber) {
		this.followingNumber = followerNumber;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
}
