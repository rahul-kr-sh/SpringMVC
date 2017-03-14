package com.mmt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.Logger;

import com.mmt.model.bean.Flight;
import com.mmt.model.bl.AdminBlMMT;
import com.mmt.model.bl.FlightBookingBlMMT;


public class AdminFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//private static Logger logger=Logger.getLogger(AdminFlightServlet.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String option=(String)request.getParameter("option");
		Flight flightSearched=null;
		ArrayList<Flight> arrayListFlight=null;
		AdminBlMMT adminFlight=new AdminBlMMT();
		FlightBookingBlMMT flightBl=new FlightBookingBlMMT();
		int row=0;
		String msg=null;
		if(option.equalsIgnoreCase("insert"))
		{
			Flight flight=new Flight();
			flight.setFlightId(request.getParameter("flightId"));
			flight.setFlightCompanyName(request.getParameter("flightCompanyName"));
			flight.setFlightSource(request.getParameter("flightSource"));
			flight.setFlightDestination(request.getParameter("flightDestination"));
			flight.setFlightDepartureTime(request.getParameter("flightDepartureTime"));
			flight.setFlightArrivalTime(request.getParameter("flightArrivalTime"));
			flight.setFlightTicketPrice(Double.parseDouble(request.getParameter("flightTicketPrice")));
			flight.setAvailableSeats(Integer.parseInt(request.getParameter("availableSeats")));
			try {
				row=adminFlight.insertFlight(flight);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(row>0){
				
				msg="Flight Successfully Added";
			//	BasicConfigurator.configure();
		 	  //  logger.info("Flight Successfully Added"); 
				session.setAttribute("msg",msg);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulFlightInsertion.jsp");
				dispatch.forward(request, response);
				
			}
			else{
				msg="Flight Insertion Failed";
				session.setAttribute("msg",msg);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulFlightInsertion.jsp");
				dispatch.forward(request, response);
				
			}
		}
		else if(option.equalsIgnoreCase("delete"))
		{
			System.out.println("Inside delete of flight");
			String flightId=request.getParameter("flightId");
			try {
				row=adminFlight.deleteFlight(flightId);
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			if(row>0){
				msg="Flight Successfully Deleted";
			//	logger.info("Flight Successfully Deleted");
				session.setAttribute("msg",msg);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulFlightInsertion.jsp");
				dispatch.forward(request, response);
			}
			else{
				
				msg="Flight deletion Failed";
				session.setAttribute("msg",msg);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulFlightInsertion.jsp");
				dispatch.forward(request, response);
			}
		}
		else if(option.equalsIgnoreCase("update"))
		{
			System.out.println("Inside update of flight");
			Flight newFlight=new Flight();
			String oldFlightId=request.getParameter("oldflightId");
			newFlight.setFlightId(request.getParameter("newflightId"));
			newFlight.setFlightCompanyName(request.getParameter("flightCompanyName"));
			newFlight.setFlightSource(request.getParameter("flightSource"));
			newFlight.setFlightDestination(request.getParameter("flightDestination"));
			newFlight.setFlightDepartureTime(request.getParameter("flightDepartureTime"));
			newFlight.setFlightArrivalTime(request.getParameter("flightArrivalTime"));
			newFlight.setFlightTicketPrice(Double.parseDouble(request.getParameter("flightTicketPrice")));
			newFlight.setAvailableSeats(Integer.parseInt(request.getParameter("availableSeats")));
			try {
				row=adminFlight.modifyFlight(oldFlightId, newFlight);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(row>0){
				msg="Flight Successfully Updated";
			//	logger.info("Flight Successfully Updated");
				session.setAttribute("msg",msg);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulFlightInsertion.jsp");
				dispatch.forward(request, response);
			}
			else{
				
				msg="Flight Updation Failed";
				session.setAttribute("msg",msg);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulFlightInsertion.jsp");
				dispatch.forward(request, response);
			}
		}
		else if(option.equalsIgnoreCase("search"))
		{
			String searchFlightId=request.getParameter("flightId");
			try {
				flightSearched=flightBl.searchFlight(searchFlightId);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(flightSearched==null){
				msg="Flight doesn't Exist with ID = "+searchFlightId;
				session.setAttribute("msg",msg);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulFlightInsertion.jsp");
				dispatch.forward(request, response);
			}
			else{	
				session.setAttribute("flightSearched",flightSearched);
				RequestDispatcher dispatch = request.getRequestDispatcher("AdminSearchedFlight.jsp");
				dispatch.forward(request, response);
			}
		}
		else if(option.equalsIgnoreCase("display"))
		{
			try {
				arrayListFlight=flightBl.displayFlight();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(arrayListFlight.isEmpty()){
				msg="No Flights Exist ";
				session.setAttribute("msg",msg);
				RequestDispatcher dispatch = request.getRequestDispatcher("SuccessfulFlightInsertion.jsp");
				dispatch.forward(request, response);
			}
			else{
				session.setAttribute("arrayListFlight",arrayListFlight);
				RequestDispatcher dispatch = request.getRequestDispatcher("AdminDisplayAllFlights.jsp");
				dispatch.forward(request, response);
			}
		}
		
	}
//modifyFlight(String flightId, Flight newflight)
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
