package com.mmt.model.bean;
public class Promotion {
	private String promotionId;
	private String promotionName;
	private double promotionDiscount;
	private String promotionExpiryDate;
	private double promotionMinRequiredAmount;
	private String promotionType;
	public Promotion(String promotionId, String promotionName, double promotionDiscount, String promotionExpiryDate,
			double promotionMinRequiredAmount, String promotionType) {
		super();
		this.promotionId = promotionId;
		this.promotionName = promotionName;
		this.promotionDiscount = promotionDiscount;
		this.promotionExpiryDate = promotionExpiryDate;
		this.promotionMinRequiredAmount = promotionMinRequiredAmount;
		this.promotionType = promotionType;
	}
	public Promotion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}
	public String getPromotionName() {
		return promotionName;
	}
	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}
	public double getPromotionDiscount() {
		return promotionDiscount;
	}
	public void setPromotionDiscount(double promotionDiscount) {
		this.promotionDiscount = promotionDiscount;
	}
	public String getPromotionExpiryDate() {
		return promotionExpiryDate;
	}
	public void setPromotionExpiryDate(String promotionExpiryDate) {
		this.promotionExpiryDate = promotionExpiryDate;
	}
	public double getPromotionMinRequiredAmount() {
		return promotionMinRequiredAmount;
	}
	public void setPromotionMinRequiredAmount(double d) {
		this.promotionMinRequiredAmount = d;
	}
	public String getPromotionType() {
		return promotionType;
	}
	public void setPromotionType(String promotionType) {
		this.promotionType = promotionType;
	}
	@Override
	public String toString() {
		return "Promotion [promotionId=" + promotionId + ", promotionName=" + promotionName + ", promotionDiscount="
				+ promotionDiscount + ", promotionExpiryDate=" + promotionExpiryDate + ", promotionMinRequiredAmount="
				+ promotionMinRequiredAmount + ", promotionType=" + promotionType + "]";
	} 
	
	
}
