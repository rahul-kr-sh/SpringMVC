package com.mmt.controller;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mmt.model.bean.Hotel;
import com.mmt.model.bean.HotelBooking;
import com.mmt.model.bl.HotelBlMMT;

public class SearchHotelByPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String place = request.getParameter("place");
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String rooms=request.getParameter("room");
		int noOfRooms=Integer.parseInt(rooms);
		session.setAttribute("noOfRooms", noOfRooms);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = null;
		try {
			d1 = (Date) dateFormat.parse(from);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date d2 = null;
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			d2 = (Date) dateFormat1.parse(to);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("din", d1);
		session.setAttribute("dout", d2);
		long diff = d2.getTime() - d1.getTime();
		int duration = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		session.setAttribute("duration", duration);
		int room = Integer.parseInt(request.getParameter("room"));
		session.setAttribute("place", place);
		session.setAttribute("from", from);
		session.setAttribute("to", to);
		session.setAttribute("room", room);
		HotelBlMMT hotelBl = new HotelBlMMT();
		ArrayList<Hotel> arrayListHotel = null;
		try {
			arrayListHotel = hotelBl.searchHotel1(place);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (arrayListHotel.isEmpty()) {
			String message = "No Hotels found in " + place;
			session.setAttribute("message", message);
			response.sendRedirect("NoHotelInPlace.jsp");
		} else {
			session.setAttribute("arrayListHotel", arrayListHotel);
			RequestDispatcher dispatch = request.getRequestDispatcher("DisplayAllHotelPlace.jsp");
			dispatch.forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
