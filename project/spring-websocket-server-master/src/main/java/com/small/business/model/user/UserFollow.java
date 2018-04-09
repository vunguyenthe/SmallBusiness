package com.small.business.model.user;

import com.small.business.model.base.BaseMessage;

public class UserFollow extends BaseMessage {
	private Long userId = 0L;
	private Long followerId = 0L;
	private Long followingId = 0L;
	public Long getFollowerId() {
		return followerId;
	}
	public void setFollowerId(Long followerId) {
		this.followerId = followerId;
	}
	public Long getFollowingId() {
		return followingId;
	}
	public void setFollowingId(Long followingId) {
		this.followingId = followingId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
