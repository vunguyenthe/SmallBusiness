package com.small.business.model.bidjob;

import com.small.business.model.base.BaseMessage;

public class BidJobFeedback extends BaseMessage {
	private Long bidJobId = 0L;
	private String comment;
	private Long iLevel = 0L;
	private Long userId = 0L;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getBidJobId() {
		return bidJobId;
	}
	public void setBidJobId(Long bidJobId) {
		this.bidJobId = bidJobId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Long getiLevel() {
		return iLevel;
	}
	public void setiLevel(Long iLevel) {
		this.iLevel = iLevel;
	}
	@Override
	public String toString() {
		return "BidJobFeedback [bidJobId=" + bidJobId + ", comment=" + comment
				+ ", iLevel=" + iLevel + ", userId=" + userId + "]";
	}
	
}
