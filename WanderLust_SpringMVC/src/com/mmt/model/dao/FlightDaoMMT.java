package com.mmt.model.dao;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mmt.model.bean.Flight;


public interface FlightDaoMMT {
	ArrayList<Flight> displayFlight() throws ClassNotFoundException, SQLException, IOException;
	Flight searchFlight(String flightId) throws ClassNotFoundException, SQLException, IOException;
	ArrayList<Flight> searchFlight(String flightSource, String flightDestination) throws ClassNotFoundException, SQLException, IOException;
	int updateFlight(String flightId, Flight newflight) throws ClassNotFoundException, SQLException, IOException;
	int insertFlight(Flight f) throws ClassNotFoundException, SQLException, IOException;
	int deleteFlight(String flightId) throws ClassNotFoundException, SQLException, IOException;
}
