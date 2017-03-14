package com.mmt.model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mmt.model.bean.HotelBooking;

public interface HotelBookingDaoMMT {
	int insertHotelBooking(HotelBooking hb) throws SQLException, ClassNotFoundException, IOException;
	ArrayList<HotelBooking> searchHotelBooking(String userId) throws SQLException, ClassNotFoundException, IOException;
	int cancelHotelBooking(String hotelBookingId) throws SQLException, ClassNotFoundException, IOException;
	ArrayList<HotelBooking> display() throws SQLException, ClassNotFoundException, IOException;
}
