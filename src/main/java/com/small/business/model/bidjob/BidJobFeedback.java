package com.small.business.model.bidjob;

import com.small.business.model.base.BaseMessage;

public class BidJobFeedback extends BaseMessage {
	private Long bidJobId = 0L;
	private String comment;
	private int level = 0;
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "BidJobFeedback [bidJobId=" + bidJobId + ", comment=" + comment
				+ ", level=" + level + "]";
	}
}
