package com.mmt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mmt.model.bean.Flight;
import com.mmt.model.bl.FlightBookingBlMMT;

public class SearchFlightBySnDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String departureDate = request.getParameter("departureDate");
		int seats = Integer.parseInt(request.getParameter("seats"));
		FlightBookingBlMMT flightBookBl = new FlightBookingBlMMT();
		ArrayList<Flight> arrayListFlight = null;
		try {
			arrayListFlight = flightBookBl.searchFlight(source, destination);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (arrayListFlight.isEmpty()) {
			String message = "No Flights from  " + source + " to " + destination;
			session.setAttribute("message", message);
			response.sendRedirect("NoFlightFromStD.jsp");
		} else {

			session.setAttribute("seats", seats);
			session.setAttribute("source", source);
			session.setAttribute("destination", destination);
			session.setAttribute("departureDate", departureDate);
			session.setAttribute("arrayListFlight", arrayListFlight);
			if(session.getAttribute("user")!=null){
				RequestDispatcher dispatch = request.getRequestDispatcher("LoggedInDisplayAllFlightsStD.jsp");
				dispatch.forward(request, response);

			}
			else{
			RequestDispatcher dispatch = request.getRequestDispatcher("DisplayAllFlightsStD.jsp");
			dispatch.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
