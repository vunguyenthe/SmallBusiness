package com.small.business.model.user;

public class Partner {
	private Long idCard = 0L;
	private Long passportNumber = 0L;
	private String tempAddress;
	private String permanentAddress;
	private String bankAccountNumberId;
	private Integer activated;
	public Long getIdCard() {
		return idCard;
	}
	public void setIdCard(Long idCard) {
		this.idCard = idCard;
	}
	public Long getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(Long passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getTempAddress() {
		return tempAddress;
	}
	public void setTempAddress(String tempAddress) {
		this.tempAddress = tempAddress;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getBankAccountNumberId() {
		return bankAccountNumberId;
	}
	public void setBankAccountNumberId(String bankAccountNumberId) {
		this.bankAccountNumberId = bankAccountNumberId;
	}
	public Integer getActivated() {
		return activated;
	}
	public void setActivated(Integer activated) {
		this.activated = activated;
	}
	@Override
	public String toString() {
		return "Partner [idCard=" + idCard + ", passportNumber="
				+ passportNumber + ", tempAddress=" + tempAddress
				+ ", permanentAddress=" + permanentAddress
				+ ", bankAccountNumberId=" + bankAccountNumberId
				+ ", activated=" + activated + "]";
	}
	
	
}
