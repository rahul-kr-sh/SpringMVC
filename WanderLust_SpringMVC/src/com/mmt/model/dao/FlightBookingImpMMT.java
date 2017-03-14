package com.mmt.model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.mmt.model.bean.FlightBooking;

public class FlightBookingImpMMT implements FlightBookingDaoMMT {
	Connection con;
	//display the details of flightbooking
	@Override
	public ArrayList<FlightBooking> displayFlightBooking() throws ClassNotFoundException, SQLException, IOException {
		{
			ArrayList<FlightBooking> FB = new ArrayList<FlightBooking>();
			FlightBooking fb = new FlightBooking();
			con = DbConnection.dbConnection();
			// Query
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from FLIGHTBOOKING");

			while (rs.next()) {
				fb.setFlightBookingId(rs.getString("flightBookingId"));
				fb.setFlightId(rs.getString("flightId"));
				fb.setUserId(rs.getString("userId"));
				fb.setFlightBookingId(rs.getString("flightBookingDate"));

				String status = "false";
				if (rs.getString("flag").equals("true")){
					status = "true";

					fb.setFlag(true);
				}
		
				

			}
			con.close();

			return FB;
		}
	}

	@Override
	public ArrayList<FlightBooking> searchFlightBooking(String userId)
			throws ClassNotFoundException, SQLException, IOException {

		FlightBooking fb =null;
		ArrayList<FlightBooking> fList = new ArrayList<FlightBooking>();
		ResultSet rs;
		con = DbConnection.dbConnection();
		// Query
		PreparedStatement pst = con.prepareStatement("select * from FLIGHTBOOKING where userId=?");
		pst.setString(1, userId);
		rs = pst.executeQuery();
		while (rs.next()) {
			fb= new FlightBooking();
			fb.setFlightBookingId(rs.getString("flightBookingId"));
			fb.setFlightId(rs.getString("flightId"));
			fb.setUserId(rs.getString("userId"));
			Date d = rs.getDate(4);
		//	java.sql.Date sqlDate1 = new java.sql.Date(d.getTime());
			fb.setFlightBookingDate(d);

			String status = "false";
			if (rs.getString("flag").equalsIgnoreCase("true")) {
				status = "true";

				fb.setFlag(true);
			}

			fList.add(fb);
		}
		con.close();

		return fList;
	}
	// insert function for the flight booking 
	@Override
	public int insertFlightBooking(FlightBooking fb) throws ClassNotFoundException, SQLException, IOException {

		con = DbConnection.dbConnection();
		int row = 0;
		// Statement stmt = con.createStatement();
		//System.out.println("DAOPrint:"+fb);
		PreparedStatement pst = con.prepareStatement("insert into FLIGHTBOOKING values(?,?,?,?,?)");
		pst.setString(1, fb.getFlightBookingId());
		pst.setString(2, fb.getUserId());
		pst.setString(3, fb.getFlightId());
		Date d = fb.getFlightBookingDate();
		java.sql.Date sqlDate1 = new java.sql.Date(d.getTime());
		pst.setDate(4,sqlDate1 );
		String status = "false";
		if (fb.isFlag()) {
			status = "true";
			pst.setString(5, status);
		}

		row = pst.executeUpdate();

		con.close();
		return row;
	}

	// delete function for the flight booking
	@Override
	public int deleteFlightBooking(String flightBookingId) throws ClassNotFoundException, SQLException, IOException {

		con = DbConnection.dbConnection();

		Statement stmt = con.createStatement();
		int rows = stmt.executeUpdate("delete from FLIGHTBOOKING where flightBookingId =" + flightBookingId);
		// Process Results

		con.close();
		return rows;
	}

	@Override
	public ArrayList<FlightBooking> displayFlightBooking1() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
