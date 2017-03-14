package com.mmt.model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mmt.model.bean.Hotel;
import com.mmt.model.bean.HotelRoom;

public interface HotelDaoMMT {
	int insertHotel(Hotel h) throws  SQLException, ClassNotFoundException, IOException  ;
	int deleteHotel(String hotelId) throws  SQLException, ClassNotFoundException, IOException;
	int updateHotel(String hotelId, Hotel newhotel) throws  SQLException, ClassNotFoundException, IOException;
	ArrayList<Hotel> displayHotel() throws  SQLException, ClassNotFoundException, IOException ;
	Hotel searchHotel(String hotelId) throws SQLException, ClassNotFoundException, IOException ;
	//Hotel searchHotel(String hotelLocation) throws SQLException ;
	ArrayList<Hotel> searchHotel1(String hotelLocation) throws SQLException, ClassNotFoundException, IOException;
	
}
