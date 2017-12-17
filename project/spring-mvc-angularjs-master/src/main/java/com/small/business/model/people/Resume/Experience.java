package com.small.business.model.people.Resume;

public class Experience {
	private String date_start;
	private String jobtitle;
	private String description;
	private String date_end;
	public String getDate_start() {
		return date_start;
	}
	public void setDate_start(String date_start) {
		this.date_start = date_start;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate_end() {
		return date_end;
	}
	public void setDate_end(String date_end) {
		this.date_end = date_end;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((date_end == null) ? 0 : date_end.hashCode());
		result = prime * result
				+ ((date_start == null) ? 0 : date_start.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((jobtitle == null) ? 0 : jobtitle.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Experience other = (Experience) obj;
		if (date_end == null) {
			if (other.date_end != null)
				return false;
		} else if (!date_end.equals(other.date_end))
			return false;
		if (date_start == null) {
			if (other.date_start != null)
				return false;
		} else if (!date_start.equals(other.date_start))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (jobtitle == null) {
			if (other.jobtitle != null)
				return false;
		} else if (!jobtitle.equals(other.jobtitle))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Experience [date_start=" + date_start + ", jobtitle=" + jobtitle
				+ ", description=" + description + ", date_end=" + date_end
				+ "]";
	}
	
}
