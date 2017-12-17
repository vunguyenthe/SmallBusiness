package com.small.business.model.people.Resume;

import java.util.ArrayList;
import java.util.List;

import com.small.business.model.base.BaseMessage;

public class PeopleResume extends BaseMessage {
	private List<Description> summary = new ArrayList<Description>();
	private List<Description> education_and_training = new ArrayList<Description>();
	private List<Description> skills = new ArrayList<Description>();
	private BasicInformation basics;
	private List<Description> awards = new ArrayList<>();
	private List<Experience> work_experience = new ArrayList<Experience>();
	public List<Description> getSummary() {
		return summary;
	}
	public void setSummary(List<Description> summary) {
		this.summary = summary;
	}
	public List<Description> getEducation_and_training() {
		return education_and_training;
	}
	public void setEducation_and_training(
			List<Description> education_and_training) {
		this.education_and_training = education_and_training;
	}
	public List<Description> getSkills() {
		return skills;
	}
	public void setSkills(List<Description> skills) {
		this.skills = skills;
	}
	public BasicInformation getBasics() {
		return basics;
	}
	public void setBasics(BasicInformation basics) {
		this.basics = basics;
	}
	public List<Description> getAwards() {
		return awards;
	}
	public void setAwards(List<Description> awards) {
		this.awards = awards;
	}
	public List<Experience> getWork_experience() {
		return work_experience;
	}
	public void setWork_experience(List<Experience> work_experience) {
		this.work_experience = work_experience;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((awards == null) ? 0 : awards.hashCode());
		result = prime * result + ((basics == null) ? 0 : basics.hashCode());
		result = prime * result + ((education_and_training == null) ? 0
				: education_and_training.hashCode());
		result = prime * result + ((skills == null) ? 0 : skills.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result
				+ ((work_experience == null) ? 0 : work_experience.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PeopleResume other = (PeopleResume) obj;
		if (awards == null) {
			if (other.awards != null)
				return false;
		} else if (!awards.equals(other.awards))
			return false;
		if (basics == null) {
			if (other.basics != null)
				return false;
		} else if (!basics.equals(other.basics))
			return false;
		if (education_and_training == null) {
			if (other.education_and_training != null)
				return false;
		} else if (!education_and_training.equals(other.education_and_training))
			return false;
		if (skills == null) {
			if (other.skills != null)
				return false;
		} else if (!skills.equals(other.skills))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (work_experience == null) {
			if (other.work_experience != null)
				return false;
		} else if (!work_experience.equals(other.work_experience))
			return false;
		return true;
	}
	
}
