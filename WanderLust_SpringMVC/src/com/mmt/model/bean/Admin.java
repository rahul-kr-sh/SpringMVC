package com.mmt.model.bean;

public class Admin {
	
	private String adminId;
	private String adminName;
	private long adminPhoneNo;
	private String adminEmailId;
	private String adminAddress;
	
	private String adminPassword;
	public Admin(String adminId, String adminName, long adminPhoneNo, String adminEmailId, String adminAddress,
			String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPhoneNo = adminPhoneNo;
		this.adminEmailId = adminEmailId;
		this.adminAddress = adminAddress;
		this.adminPassword = adminPassword;
	}
	public Admin() {
		super();
		
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public long getAdminPhoneNo() {
		return adminPhoneNo;
	}
	public void setAdminPhoneNo(long adminPhoneNo) {
		this.adminPhoneNo = adminPhoneNo;
	}
	public String getAdminEmailId() {
		return adminEmailId;
	}
	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}
	public String getAdminAddress() {
		return adminAddress;
	}
	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPhoneNo=" + adminPhoneNo
				+ ", adminEmailId=" + adminEmailId + ", adminAddress=" + adminAddress + ", adminPassword="
				+ adminPassword + "]";
	}
	
	
}
