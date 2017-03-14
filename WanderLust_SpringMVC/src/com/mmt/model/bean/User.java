package com.mmt.model.bean;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class User implements Serializable{
	
	@Size(min=4, max=12)
	private String userId;
	@Size(min=4, max=20)
	private String userName;
//	@ValidatePhone
	private long userPhoneNo;
	@NotEmpty
	@Email
	private String userEmailId;
	@Size(min=20, max=50)
	private String userAddress;
	@Size(min=8, max=20)
	private String userPassword;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userId, String userName, long userPhoneNo, String userEmailId, String userAddress,
			String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPhoneNo = userPhoneNo;
		this.userEmailId = userEmailId;
		this.userAddress = userAddress;
		this.userPassword = userPassword;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getUserPhoneNo() {
		return userPhoneNo;
	}
	public void setUserPhoneNo(long userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPhoneNo=" + userPhoneNo + ", userEmailId="
				+ userEmailId + ", userAddress=" + userAddress + ", userPassword=" + userPassword + "]";

	}

}	

	
	
	

