package com.mmt.model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mmt.model.bean.FlightBooking;

public interface FlightBookingDaoMMT {
	
	ArrayList<FlightBooking> displayFlightBooking1() throws ClassNotFoundException, SQLException;
	
	ArrayList<FlightBooking> searchFlightBooking(String flightBookingId) throws ClassNotFoundException, SQLException, IOException;
	
	
	int insertFlightBooking(FlightBooking fb) throws ClassNotFoundException, SQLException, IOException;
	
	int deleteFlightBooking(String flightBookingId) throws ClassNotFoundException, SQLException, IOException;

	ArrayList<FlightBooking> displayFlightBooking() throws ClassNotFoundException, SQLException, IOException;

//	//FlightBooking displayFlightBooking(String userID){
//		
//	}



}
