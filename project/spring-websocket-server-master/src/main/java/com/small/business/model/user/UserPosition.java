package com.small.business.model.user;

public class UserPosition {
	Long userId = 0L;
    private String name = "";
    private String phoneNumber = "";
    private String dayOfBirth = "";
    private String CMND = "";
    private String passKey = "";
    private String issuedDay = "";
    private String issuedPlace = "";
    private String frontPhoto = "";
    private String backPhoto = "";
    private String email = "";
    private String degree = "";
    private String certificateOfInformatics = "";
    private Integer userType = 0;
    private Integer isActivated = 0;
    private String registeredDay = "";
    private Long iRegisteredDay = 0L;
    private String sex = "";
	Long longitude = 0L;
	Long latitude = 0L;
	private Integer miaApproval = 0;
	
	public Integer getMiaApproval() {
		return miaApproval;
	}
	public void setMiaApproval(Integer miaApproval) {
		this.miaApproval = miaApproval;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
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
	public Long getLongitude() {
		return longitude;
	}
	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}
	public Long getLatitude() {
		return latitude;
	}
	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}
	public Integer getIsActivated() {
		return isActivated;
	}
	public void setIsActivated(Integer isActivated) {
		this.isActivated = isActivated;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
