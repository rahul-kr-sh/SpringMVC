package com.mmt.model.bean;

import java.util.ArrayList;
import java.util.Date;

public class Hotel {
	private String hotelId;
	private String hotelName;
	private String hotelLocation;
	private String hotelInfo;
	private String hotelImage;
	private ArrayList<HotelRoom> hotelRoom;
	
	public Hotel(String hotelId, String hotelName, String hotelLocation, String hotelInfo, String hotelImage,
			ArrayList<HotelRoom> hotelRoom) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
		this.hotelInfo = hotelInfo;
		this.hotelImage = hotelImage;
		this.hotelRoom = hotelRoom;
	}
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelLocation() {
		return hotelLocation;
	}
	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}
	public String getHotelInfo() {
		return hotelInfo;
	}
	public void setHotelInfo(String hotelInfo) {
		this.hotelInfo = hotelInfo;
	}
	public ArrayList<HotelRoom> getHotelRoom() {
		return hotelRoom;
	}
	public void setHotelRoom(ArrayList<HotelRoom> hotelRoom) {
		this.hotelRoom = hotelRoom;
	}
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelLocation=" + hotelLocation
				+ ", hotelInfo=" + hotelInfo + ", hotelImage=" + hotelImage + ", hotelRoom=" + hotelRoom + "]";
	}
	public String getHotelImage() {
		return hotelImage;
	}
	public void setHotelImage(String hotelImage) {
		this.hotelImage = hotelImage;
	}
	
	
	
}
