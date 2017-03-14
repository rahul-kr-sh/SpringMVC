package com.mmt.model.bean;

public class HotelRoom {
	private String hotelId;
	private int hotelRoomNo;
	private String hotelRoomType;
	private double hotelRoomPrice;
	private String hotelRoomStatus;
	public HotelRoom(String hotelId,int hotelRoomNo, String hotelRoomType, double hotelRoomPrice, String hotelRoomStatus) {
		super();
		this.hotelId=hotelId;
		this.hotelRoomNo = hotelRoomNo;
		this.hotelRoomType = hotelRoomType;
		this.hotelRoomPrice = hotelRoomPrice;
		this.hotelRoomStatus = hotelRoomStatus;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public HotelRoom() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getHotelRoomNo() {
		return hotelRoomNo;
	}
	public void setHotelRoomNo(int hotelRoomNo) {
		this.hotelRoomNo = hotelRoomNo;
	}
	public String getHotelRoomType() {
		return hotelRoomType;
	}
	public void setHotelRoomType(String hotelRoomType) {
		this.hotelRoomType = hotelRoomType;
	}
	public double getHotelRoomPrice() {
		return hotelRoomPrice;
	}
	public void setHotelRoomPrice(double hotelRoomPrice) {
		this.hotelRoomPrice = hotelRoomPrice;
	}
	public String getHotelRoomStatus() {
		return hotelRoomStatus;
	}
	public void setHotelRoomStatus(String hotelRoomStatus) {
		this.hotelRoomStatus = hotelRoomStatus;
	}
	@Override
	public String toString() {
		return "HotelRoom [hotelRoomNo=" + hotelRoomNo + ", hotelRoomType=" + hotelRoomType + ", hotelRoomPrice="
				+ hotelRoomPrice + ", hotelRoomStatus=" + hotelRoomStatus + "]";
	}
	
	
	
}
