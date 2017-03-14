package com.mmt.model.dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.mmt.model.bean.Flight;

public class FlightDaoImplMMT implements FlightDaoMMT {
	Connection con;
	
	//insert function for the flight details
	@Override
	public int insertFlight(Flight flight) throws ClassNotFoundException, SQLException, IOException {	
		
		int row=0;
		con=DbConnection.dbConnection();
		PreparedStatement pst=con.prepareStatement("insert into flight values(?,?,?,?,?,?,?,?)");

		pst.setString(1, flight.getFlightCompanyName());
		pst.setString(2, flight.getFlightId());
		pst.setString(3, flight.getFlightSource());
		pst.setString(4, flight.getFlightDestination());
		pst.setString(5, flight.getFlightDepartureTime());
		pst.setString(6, flight.getFlightArrivalTime());
		pst.setDouble(7, flight.getFlightTicketPrice());
		pst.setInt(8, flight.getAvailableSeats());
		row=pst.executeUpdate();
		con.close();
		return row;
	}

		//delete function to delete flight
	@Override
	public int deleteFlight(String flightId) throws ClassNotFoundException, SQLException, IOException {
		con=DbConnection.dbConnection();
		//Query
		int row=0;
		
		PreparedStatement pst=con.prepareStatement("delete from flight where flightId=?");
		
		pst.setString(1, flightId);
		
		row=pst.executeUpdate();
		con.close();

		return row;
	}

	//function to update flight
	@Override
	public int updateFlight(String flightId, Flight newflight) throws ClassNotFoundException, SQLException, IOException {
		Connection con=DbConnection.dbConnection();
		int row=0;
		//Query
		//Statement stmt=con.createStatement();
		
		PreparedStatement pst=con.prepareStatement("update flight set FlightCompanyName=?,  flightId=?, flightSource=?, flightDestination=?,flightDepartureTime=?,flightArrivalTime=?,flightTicketPrice=? ,availableSeats=? where flightId=?");
		
		pst.setString(1, newflight.getFlightCompanyName());
		pst.setString(2, newflight.getFlightId());
		pst.setString(3, newflight.getFlightSource());
		pst.setString(4, newflight.getFlightDestination());
		pst.setString(5, newflight.getFlightDepartureTime());
		pst.setString(6, newflight.getFlightArrivalTime());
		pst.setDouble(7, newflight.getFlightTicketPrice());
		pst.setInt(8, newflight.getAvailableSeats());
		pst.setString(9, flightId);
		row=pst.executeUpdate();
		
		con.close();
		return row;
	}

	
		//search function to search flight
	@Override
	public Flight searchFlight(String flightId) throws ClassNotFoundException, SQLException, IOException {
		Flight flight =new Flight();
		Connection con=DbConnection.dbConnection();
	
		
		PreparedStatement pst=con.prepareStatement("select * from Flight where flightId=?");
		
		pst.setString(1, flightId);
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			flight.setFlightCompanyName(rs.getString("flightCompanyName"));
			flight.setFlightId(rs.getString("flightId"));
			flight.setFlightSource(rs.getString("flightSource"));
			flight.setFlightDestination(rs.getString("flightDestination"));
			flight.setFlightDepartureTime(rs.getString("flightDepartureTime"));
			flight.setFlightArrivalTime(rs.getString("flightArrivalTime"));
			flight.setFlightTicketPrice(rs.getDouble("flightTicketPrice"));
			flight.setAvailableSeats(rs.getInt("availableSeats"));

		}
		con.close();

		return flight;
	}
	
	//display function to display all details of flight	
	
	@Override
	public ArrayList<Flight> displayFlight() throws ClassNotFoundException, SQLException, IOException {
		ArrayList<Flight> F =new ArrayList<Flight>();
		Flight f;
		con=DbConnection.dbConnection();
		//Query
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from Flight");
		//Process Results
		while(rs.next()){
			f=new Flight();
			f.setFlightCompanyName(rs.getString("flightCompanyName"));
			f.setFlightId(rs.getString("flightId"));
			f.setFlightSource(rs.getString("flightSource"));
			f.setFlightDestination(rs.getString("flightDestination"));
			f.setFlightDepartureTime(rs.getString("flightDepartureTime"));
			f.setFlightArrivalTime(rs.getString("flightArrivalTime"));
			f.setFlightTicketPrice(rs.getDouble("flightTicketPrice"));
			f.setAvailableSeats(rs.getInt("availableSeats"));
			F.add(f);
		}
		con.close();

		return F;
	}

	//search flight on the basis of source and destination
	
	@Override
	public ArrayList<Flight> searchFlight(String flightSource, String flightDestination)
			throws ClassNotFoundException, SQLException, IOException {
		Flight f =new Flight();
		ArrayList<Flight> F =new ArrayList<Flight>();
		con=DbConnection.dbConnection();
		//Query
		PreparedStatement pst;
		 pst=con.prepareStatement("select * from Flight where flightSource=? AND flightDestination=?");
		pst.setString(1, flightSource);
		 pst.setString(2, flightDestination);
		 ResultSet rs=pst.executeQuery();
		//Process Results
		while(rs.next()){
			f.setFlightCompanyName(rs.getString("flightCompanyName"));
			f.setFlightId(rs.getString("flightId"));
			f.setFlightSource(rs.getString("flightSource"));
			f.setFlightDestination(rs.getString("flightDestination"));
			f.setFlightDepartureTime(rs.getString("flightDepartureTime"));
			f.setFlightArrivalTime(rs.getString("flightArrivalTime"));
			f.setFlightTicketPrice(rs.getDouble("flightTicketPrice"));
			f.setAvailableSeats(rs.getInt("availableSeats"));
			F.add(f);

		}
		con.close();

		return F;
	}
}
