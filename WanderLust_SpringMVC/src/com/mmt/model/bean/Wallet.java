package com.mmt.model.bean;

public class Wallet {
	public Wallet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String userId;
	private double walletBalance;
	public Wallet(String userId, double walletBalance) {
		super();
		this.userId = userId;
		this.walletBalance = walletBalance;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public double getWalletBalance() {
		return walletBalance;
	}
	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}
	@Override
	public String toString() {
		return "Wallet [userId=" + userId + ", walletBalance=" + walletBalance + "]";
	}
	
	
}
