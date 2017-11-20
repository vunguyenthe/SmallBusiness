package com.small.business.model.bidjob;

import com.small.business.model.base.BaseMessage;

public class BidJob extends BaseMessage {

	private Long userId = 0L;
	private Long jobDetailId = 0L;
	private String jobName;
	private Double bidAsk = 0.00;
	private String location;
	private int IsExpired = 0;
	private int isSucceded = 0;
	private String bidTime;
	private Long iBidTime = 0L;
	
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public Long getJobDetailId() {
		return jobDetailId;
	}
	public void setJobDetailId(Long jobDetailId) {
		this.jobDetailId = jobDetailId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Double getBidAsk() {
		return bidAsk;
	}
	public void setBidAsk(Double bidAsk) {
		this.bidAsk = bidAsk;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getIsExpired() {
		return IsExpired;
	}
	public void setIsExpired(int isExpired) {
		IsExpired = isExpired;
	}
	public int getIsSucceded() {
		return isSucceded;
	}
	public void setIsSucceded(int isSucceded) {
		this.isSucceded = isSucceded;
	}
	public String getBidTime() {
		return bidTime;
	}
	public void setBidTime(String bidTime) {
		this.bidTime = bidTime;
	}
	public Long getiBidTime() {
		return iBidTime;
	}
	public void setiBidTime(Long iBidTime) {
		this.iBidTime = iBidTime;
	}
	@Override
	public String toString() {
		return "BidJob [userId=" + userId + ", bidAsk=" + bidAsk + ", location="
				+ location + ", IsExpired=" + IsExpired + ", isSucceded="
				+ isSucceded + ", bidTime=" + bidTime + ", iBidTime=" + iBidTime
				+ "]";
	}
	
}
