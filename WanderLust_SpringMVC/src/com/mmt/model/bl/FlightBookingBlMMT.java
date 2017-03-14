package com.mmt.model.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.mmt.model.bean.Flight;
import com.mmt.model.bean.FlightBooking;
import com.mmt.model.dao.FlightBookingDaoMMT;
import com.mmt.model.dao.FlightBookingImpMMT;
import com.mmt.model.dao.FlightDaoImplMMT;

public class FlightBookingBlMMT {

	FlightDaoImplMMT flightdao = new FlightDaoImplMMT();
	FlightBookingDaoMMT flightBookingDao = new FlightBookingImpMMT();

	private boolean checkAvailability(Flight F, int num) {
		boolean status = false;
		int var = num;
		Flight f = F;
		if (f.getAvailableSeats() - var < 0) {
			return status;
		} else {
			status = true;
			return status;
		}
	}

	public ArrayList<Flight> displayFlight() throws ClassNotFoundException, SQLException, IOException {
		return flightdao.displayFlight();
	}

	public Flight searchFlight(String flightId) throws ClassNotFoundException, SQLException, IOException {
		return flightdao.searchFlight(flightId);
	}

	public ArrayList<Flight> searchFlight(String flightSource, String flightDestination)
			throws ClassNotFoundException, SQLException, IOException {
		if(flightdao.searchFlight(flightSource, flightDestination)==null){
			return null;
		}
				
		return flightdao.searchFlight(flightSource, flightDestination);
	}

	public FlightBooking bookFlight(String userId, String flightId, String flightSource, String flightDestination,
			int seats) throws ClassNotFoundException, SQLException, IOException {
		String fid = flightId;
		String UId = userId;
		boolean flag = false;
		int rseats = seats;
		Flight f = flightdao.searchFlight(fid);
		if (f == null) {
			return null;
		} else {
			if (checkAvailability(f, rseats) != true) {
				System.out.println("Seats Not Available!!");
				return null;
			} else {
				f.setAvailableSeats(f.getAvailableSeats() - rseats);
				//System.out.println("Seats Available!!");
				// Date d=new Date();
				FlightBooking FBD = new FlightBooking();
				//changess
				int hbid = 10000 + (int) (Math.random() * 11000);
				//System.out.println("Random No"+hbid);
				String id = Integer.toString(hbid);
				Date date=new Date();
				FBD.setUserId(UId);
				FBD.setFlightId(fid);
				FBD.setFlightBookingId(id);
				FBD.setFlightBookingDate(date);
				FBD.setFlag(true);
				flightBookingDao.insertFlightBooking(FBD);
				flightdao.updateFlight(fid, f);
				return FBD;
			}
		}
	}
	
	
	public ArrayList<String> getSourceList() throws ClassNotFoundException, SQLException, IOException{
		ArrayList<Flight> flightList= new FlightDaoImplMMT().displayFlight();
		
		ArrayList<String> sourceList=new ArrayList<String>();
		for(Flight flight: flightList){
			
			sourceList.add(flight.getFlightSource());
		}
		return sourceList;
		
	}
	
	public ArrayList<String> getDestinationList() throws ClassNotFoundException, SQLException, IOException{
		ArrayList<Flight> flightList= new FlightDaoImplMMT().displayFlight();
	
		ArrayList<String> destList= new ArrayList<String>();
		for(Flight flight: flightList){
			
			destList.add(flight.getFlightDestination());
		}
		return destList;
		
	}

}
