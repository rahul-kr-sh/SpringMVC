package com.mmt.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mmt.model.bean.Flight;
import com.mmt.model.bean.HotelBooking;


public class HotelBookingDaoImplMMT implements HotelBookingDaoMMT {
	Connection con;

	//Insert function to add hotel details
	@Override
	public int insertHotelBooking(HotelBooking hb) throws SQLException, ClassNotFoundException, IOException {
		int row;
		con=DbConnection.dbConnection();
		PreparedStatement pst=con.prepareStatement("insert into HotelBooking values(?,?,?,?,?,?,?)");
		pst.setString(1, hb.getHotelBookingId());
		pst.setString(2, hb.getHotelId());
		pst.setString(3, hb.getUserId());
		pst.setInt(4, hb.getRoomNo());
		Date d = hb.getHotelCheckInDate();
		java.sql.Date sqlDate1 = new java.sql.Date(d.getTime());
		pst.setDate(5, sqlDate1);
		Date d1 =hb.getHotelCheckOutDate();
		java.sql.Date sqlDate2 = new java.sql.Date(d1.getTime());
		pst.setDate(6, sqlDate2 );
		pst.setInt(7, hb.getStayDuration());
		row=pst.executeUpdate();
		//System.out.println("----------");
		//System.out.println("DAO"+hb);
		con.close();
		return row;
	}

	//search function to search hotel
	@Override
	public ArrayList<HotelBooking> searchHotelBooking(String userId) throws SQLException, ClassNotFoundException, IOException {
		ArrayList<HotelBooking> hb =new ArrayList<HotelBooking>();
		HotelBooking h;
		ResultSet rs;
		con=DbConnection.dbConnection();
		PreparedStatement pst=con.prepareStatement("select * from hotelbooking where userId=?");
		pst.setString(1, userId);
		rs=pst.executeQuery();
		while(rs.next()){
			h=new HotelBooking();;
			h.setHotelBookingId(rs.getString("hotelBookingId"));
			h.setHotelId(rs.getString("hotelId"));
			h.setUserId(rs.getString("userId"));
			h.setRoomNo(rs.getInt("roomNo"));
			h.setHotelCheckInDate(rs.getDate("hotelCheckInDate"));
			h.setHotelCheckOutDate(rs.getDate("hotelCheckOutDate"));
			h.setStayDuration(rs.getInt("stayDuration"));
			hb.add(h);
			//System.out.println("DAO "+h);
		}
		return hb;
	}
	
	//function to cancle the hotel booking
	@Override
	public int cancelHotelBooking(String hotelBookingId) throws SQLException, ClassNotFoundException, IOException {
		con=DbConnection.dbConnection();
		Statement stmt3=con.createStatement();
		 int rows=stmt3.executeUpdate("delete from HotelBooking where hotelBookingId ="+hotelBookingId);
	
		//Process Results
		if(rows>0)
		{
			return rows;
		}
		else 
			return 0;
	}

	// function to display the hotel list
	@Override
	public ArrayList<HotelBooking> display() throws SQLException, ClassNotFoundException, IOException {
		ArrayList<HotelBooking> hb =new ArrayList<HotelBooking>();
		HotelBooking h=new HotelBooking();
		con=DbConnection.dbConnection();
		//Query
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from HotelBooking");
		//Process Results
		while(rs.next()){
			h.setHotelBookingId(rs.getString("hotelBookingId"));
			h.setHotelId(rs.getString("hotelId"));
			h.setUserId(rs.getString("userId"));
			h.setRoomNo(rs.getInt("roomNo"));
			h.setHotelCheckInDate(rs.getDate("hotelCheckInDate"));
			h.setHotelCheckOutDate(rs.getDate("hotelCheckOutDate"));
			h.setStayDuration(rs.getInt("stayDuration"));
			hb.add(h);
		}
		return hb;
	}


}
