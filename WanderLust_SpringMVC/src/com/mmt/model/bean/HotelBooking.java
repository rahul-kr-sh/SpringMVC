package com.mmt.model.bean;

import java.util.Date;

public class HotelBooking {
	private String hotelBookingId;
	private String hotelId;
	private String userId;
	private int roomNo;
	private Date hotelCheckInDate;
	private Date hotelCheckOutDate;
	private int stayDuration;
	
	public HotelBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HotelBooking(String hotelBookingId, String hotelId, String userId, int roomNo, Date hotelCheckInDate,
			Date hotelCheckOutDate, int stayDuration) {
		super();
		this.hotelBookingId = hotelBookingId;
		this.hotelId = hotelId;
		this.userId = userId;
		this.roomNo = roomNo;
		this.hotelCheckInDate = hotelCheckInDate;
		this.hotelCheckOutDate = hotelCheckOutDate;
		this.stayDuration = stayDuration;
	}

	public String getHotelBookingId() {
		return hotelBookingId;
	}

	public void setHotelBookingId(String hotelBookingId) {
		this.hotelBookingId = hotelBookingId;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public Date getHotelCheckInDate() {
		return hotelCheckInDate;
	}

	public void setHotelCheckInDate(Date hotelCheckInDate) {
		this.hotelCheckInDate = hotelCheckInDate;
	}

	public Date getHotelCheckOutDate() {
		return hotelCheckOutDate;
	}

	public void setHotelCheckOutDate(Date hotelCheckOutDate) {
		this.hotelCheckOutDate = hotelCheckOutDate;
	}

	public int getStayDuration() {
		return stayDuration;
	}

	public void setStayDuration(int stayDuration) {
		this.stayDuration = stayDuration;
	}

	@Override
	public String toString() {
		return "HotelBooking [hotelBookingId=" + hotelBookingId + ", hotelId=" + hotelId + ", userId=" + userId
				+ ", roomNo=" + roomNo + ", hotelCheckInDate=" + hotelCheckInDate + ", hotelCheckOutDate="
				+ hotelCheckOutDate + ", stayDuration=" + stayDuration + "]";
	}
	
	
}
