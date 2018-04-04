package com.small.business.model.user;

import com.small.business.model.base.BaseMessage;

public class User extends BaseMessage {

    private String name;
    private String phoneNumber;
    private String dayOfBirth ="";
    private String CMND ="";
    private String passKey ="";
    private String issuedDay ="";
    private String issuedPlace ="";
    private String frontPhoto ="";
    private String backPhoto ="";
    private String email ="";
    private String degree ="";
    private String certificateOfInformatics ="";
    private Integer userType = 0;
    private Integer isActiavated = 0;
    private String registeredDay;
    private Long iRegisteredDay = 0L;
    //private Integer isExpired;
    private String sex ="";
    private Integer miaApproval = 0;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDayOfBirth() {
		return dayOfBirth;
	}
	public void setDayOfBirth(String dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public String getPassKey() {
		return passKey;
	}
	public void setPassKey(String passKey) {
		this.passKey = passKey;
	}
	public String getIssuedDay() {
		return issuedDay;
	}
	public void setIssuedDay(String issuedDay) {
		this.issuedDay = issuedDay;
	}
	
	public String getIssuedPlace() {
		return issuedPlace;
	}
	public void setIssuedPlace(String issuedPlace) {
		this.issuedPlace = issuedPlace;
	}
	public String getFrontPhoto() {
		return frontPhoto;
	}
	public void setFrontPhoto(String frontPhoto) {
		this.frontPhoto = frontPhoto;
	}
	public String getBackPhoto() {
		return backPhoto;
	}
	public void setBackPhoto(String backPhoto) {
		this.backPhoto = backPhoto;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getCertificateOfInformatics() {
		return certificateOfInformatics;
	}
	public void setCertificateOfInformatics(String certificateOfInformatics) {
		this.certificateOfInformatics = certificateOfInformatics;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	
	public Integer getIsActiavated() {
		return isActiavated;
	}
	public void setIsActiavated(Integer isActiavated) {
		this.isActiavated = isActiavated;
	}
	public String getRegisteredDay() {
		return registeredDay;
	}
	public void setRegisteredDay(String registeredDay) {
		this.registeredDay = registeredDay;
	}
	public Long getiRegisteredDay() {
		return iRegisteredDay;
	}
	public void setiRegisteredDay(Long iRegisteredDay) {
		this.iRegisteredDay = iRegisteredDay;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Integer getMiaApproval() {
		return miaApproval;
	}
	public void setMiaApproval(Integer miaApproval) {
		this.miaApproval = miaApproval;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", phoneNumber=" + phoneNumber + ", dayOfBirth=" + dayOfBirth + ", CMND=" + CMND
				+ ", passKey=" + passKey + ", issuedDay=" + issuedDay + ", issuedPlace=" + issuedPlace + ", frontPhoto="
				+ frontPhoto + ", backPhoto=" + backPhoto + ", email=" + email + ", degree=" + degree
				+ ", certificateOfInformatics=" + certificateOfInformatics + ", userType=" + userType
				+ ", isActiavated=" + isActiavated + ", registeredDay=" + registeredDay + ", iRegisteredDay="
				+ iRegisteredDay + "]";
	}
    
}
