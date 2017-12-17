package com.small.business.model.bidjob;

public class RateInfo {
	private int level = 0;
	private String description;
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "RateInfo [level=" + level + ", description=" + description
				+ "]";
	}
}
