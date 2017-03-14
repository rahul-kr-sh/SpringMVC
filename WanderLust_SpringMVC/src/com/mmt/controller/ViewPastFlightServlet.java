package com.mmt.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mmt.model.bean.Flight;
import com.mmt.model.bl.FlightBookingBlMMT;


public class ViewPastFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
//		String viewFlightId = request.getParameter("viewFlightId");
		Flight flight=new Flight();
		FlightBookingBlMMT flightBookingBlMMT=new FlightBookingBlMMT();
		try {
			flight=flightBookingBlMMT.searchFlight((String) session.getAttribute("viewFlightId"));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("viewedFlightDetails", flight);
		
		request.getRequestDispatcher("PrintFlightTicket.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
