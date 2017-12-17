package com.small.business.model.people;

import java.util.ArrayList;
import java.util.List;

import com.small.business.model.base.BaseMessage;

public class People extends BaseMessage {

    private String fullName;
    private String email;
    private String phoneNumber;
    private String mobilePhone;
    private String additionalPhone;
    private Long companyId = 0L;// foreign key
    private String jobTitle;
    private String businessPhone;
    private String businessFax;
    private String linkedIn;
    private String address;
    private String internalComments;
    private String cv;
    private String webLink;
    private String skypeID;
    private boolean client;
    private boolean candidate;
    private boolean partner;
    private boolean contact;
    private boolean doNotMass;
    private boolean vip;
    private boolean supplier;
    private String photo;
    private String createBy;
    private String cvShow;
    private String highlightColor;
    private boolean isHistoryPeople = false;
    private String companyName;



    public String getCvShow() {

        return cvShow;
    }

    public void setCvShow(String cvShow) {

        this.cvShow = cvShow;
    }

    public String getFullName() {

        return fullName;
    }

    public void setFullName(String fullName) {

        this.fullName = fullName;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }
    
    public String getAdditionalPhone() {
        
        return additionalPhone;
    }

    
    public void setAdditionalPhone(String additionalPhone) {
    
        this.additionalPhone = additionalPhone;
    }

    public String getMobilePhone() {

        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {

        this.mobilePhone = mobilePhone;
    }

    public Long getCompanyId() {

        return companyId;
    }

    public void setCompanyId(Long companyId) {

        this.companyId = companyId;
    }

    public String getJobTitle() {

        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {

        this.jobTitle = jobTitle;
    }

    public String getBusinessPhone() {

        return businessPhone;
    }

    public void setBusinessPhone(String businessPhone) {

        this.businessPhone = businessPhone;
    }

    public String getBusinessFax() {

        return businessFax;
    }

    public void setBusinessFax(String businessFax) {

        this.businessFax = businessFax;
    }

    public String getLinkedIn() {

        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {

        this.linkedIn = linkedIn;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getInternalComments() {

        return internalComments;
    }

    public void setInternalComments(String internalComments) {

        this.internalComments = internalComments;
    }

    public String getCv() {

        return cv;
    }

    public void setCv(String cv) {

        this.cv = cv;
    }

    public String getWebLink() {

        return webLink;
    }

    public void setWebLink(String webLink) {

        this.webLink = webLink;
    }

    public String getSkypeID() {

        return skypeID;
    }

    public void setSkypeID(String skypeID) {

        this.skypeID = skypeID;
    }

    public boolean isClient() {

        return client;
    }

    public void setClient(boolean client) {

        this.client = client;
    }

    public boolean isCandidate() {

        return candidate;
    }

    public void setCandidate(boolean candidate) {

        this.candidate = candidate;
    }

    public boolean isPartner() {

        return partner;
    }

    public void setPartner(boolean partner) {

        this.partner = partner;
    }

    public boolean isContact() {

        return contact;
    }

    public void setContact(boolean contact) {

        this.contact = contact;
    }

    public boolean isDoNotMass() {

        return doNotMass;
    }

    public void setDoNotMass(boolean doNotMass) {

        this.doNotMass = doNotMass;
    }

    public boolean isVip() {

        return vip;
    }

    public void setVip(boolean vip) {

        this.vip = vip;
    }

    public boolean isSupplier() {

        return supplier;
    }

    public void setSupplier(boolean supplier) {

        this.supplier = supplier;
    }

    public String getPhoto() {

        return photo;
    }

    public void setPhoto(String photo) {

        this.photo = photo;
    }

    public String getCreateBy() {

        return createBy;
    }

    public void setCreateBy(String createBy) {

        this.createBy = createBy;
    }

    public String getCompanyName() {

        return companyName;
    }

    public void setCompanyName(String companyName) {

        this.companyName = companyName;
    }
    
    public boolean isHistoryPeople() {
		return isHistoryPeople;
	}

	public void setHistoryPeople(boolean isHistoryPeople) {
		this.isHistoryPeople = isHistoryPeople;
	}

    public String getHighlightColor() {

        return highlightColor;
    }

    public void setHighlightColor(String highlightColor) {

        this.highlightColor = highlightColor;
    }

}